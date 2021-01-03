/*
 * Copyright (c) 2020
 * User:jan
 * File:QiuTanAsianOdds.java
 * Date:2020/12/01 08:12:01
 */

package football.over;

import com.beust.jcommander.internal.Lists;
import com.google.common.primitives.Longs;
import football.model.Company;
import football.model.EuropeCap;
import football.model.HandiCap;
import football.model.Match;
import football.model.OverUnder;
import football.util.FileUtil;
import football.util.JsoupUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author jan
 * @since 2020/12/1 8:12
 */
public class QiuTanAsianOdds implements AsianOdds {
    private static final String QIUTAN_MATCH_URL = "http://vip.win007.com/changeDetail/handicap.aspx?id=";
    private static final String QIUTAN_EUR_URL = "http://vip.win007.com/changeDetail/1x2.aspx?id=";
    private static final String QIUTAN_BIG_URL = "http://vip.win007.com/changeDetail/overunder.aspx?id=";
    private static final String ASIAN_URL = "http://vip.win007.com/AsianOdds_n.aspx?id=";
    private static final String STYLE_DISPLAY = "style";
    private static final String MAX_STR = "最大值";
    private static final String MIN_STR = "最小值";
    private static final String ROOT_PATH = "E:/football/球探/";
    private static final String EUROPE_PATH = "欧指";
    private static final String ASIAN_PATH = "亚指";
    private static final String OVERUNDER_PATH = "大小盘";

    @Override
    public List<HandiCap> queryAsianOddsByMatchId(Match match, String date) {
        long matchId = match.getMatchId();
        String homeName = match.getHomeName();
        String guestName = match.getGuestName();
        List<Company> list = getAllCompanyId(matchId);
        for (Company company : list) {
            String rootPath = ROOT_PATH + date + File.separator +
                    homeName + "-" + guestName + File.separator;
            queryEuropeCapData(matchId, company.getCompanyId(),
                    rootPath + EUROPE_PATH + File.separator +
                            company.getCompanyName());
            queryHandiCapData(matchId, company.getCompanyId(),
                    rootPath + ASIAN_PATH + File.separator +
                            company.getCompanyName());
            queryOverUnderData(matchId, company.getCompanyId(),
                    rootPath + OVERUNDER_PATH + File.separator +
                            company.getCompanyName());
        }
        list.forEach((company) -> {
            String rootPath = ROOT_PATH + date + File.separator +
                    homeName + "-" + guestName + File.separator;
            Supplier<Boolean> supplierEuropeCap =
                    () -> queryEuropeCapData(matchId, company.getCompanyId(),
                            rootPath + EUROPE_PATH + File.separator +
                                    company.getCompanyName());
            Supplier<Boolean> supplierHandiCap =
                    () -> queryHandiCapData(matchId, company.getCompanyId(),
                            rootPath + ASIAN_PATH + File.separator +
                                    company.getCompanyName());
            Supplier<Boolean> supplierOverUnder =
                    () -> queryOverUnderData(matchId, company.getCompanyId(),
                            rootPath + OVERUNDER_PATH + File.separator +
                                    company.getCompanyName());

            Arrays.asList(supplierEuropeCap, supplierHandiCap, supplierOverUnder)
                    .parallelStream().map(Supplier::get)
                    .collect(Collectors.toList());
        });
        return Collections.emptyList();
    }

    private static Boolean queryHandiCapData(long matchId, long companyId, String path) {
        List<HandiCap> handiCapList = queryHandiCapData(
                QIUTAN_MATCH_URL + matchId + "&companyid=" + companyId + "&l=0");
        saveHandiCapData(handiCapList, path, "handicap_data.txt");
        return true;
    }

    private static void saveHandiCapData(List<HandiCap> handiCapList, String path, String fileName) {
        FileUtil.createFile(path);
        List<String> stringList = handiCapList
                .stream()
                .map((HandiCap::parseObject))
                .collect(Collectors.toList());
        String filePath = path + File.separator + fileName;
        FileUtil.writeFile(filePath, stringList);
    }

    private static void saveEuropeCapData(List<EuropeCap> handiCapList, String path, String fileName) {
        FileUtil.createFile(path);
        List<String> stringList = handiCapList
                .stream()
                .map((EuropeCap::parseObject))
                .collect(Collectors.toList());
        String filePath = path + File.separator + fileName;
        FileUtil.writeFile(filePath, stringList);
    }

    private static void saveOverUnderData(List<OverUnder> handiCapList, String path, String fileName) {
        FileUtil.createFile(path);
        List<String> stringList = handiCapList
                .stream()
                .map((OverUnder::parseObject))
                .collect(Collectors.toList());
        String filePath = path + File.separator + fileName;
        FileUtil.writeFile(filePath, stringList);
    }

    private static Boolean queryOverUnderData(long matchId, long companyId, String path) {
        List<OverUnder> handiCapList = queryOverUnder(matchId, companyId);
        saveOverUnderData(handiCapList, path, "overunder_data.txt");
        return true;
    }

    private static Boolean queryEuropeCapData(long matchId, long companyId, String path) {
        List<EuropeCap> handiCapList = queryEuropeCap(matchId, companyId);
        saveEuropeCapData(handiCapList, path, "europecap_data.txt");
        return true;
    }

    private static List<HandiCap> queryHandiCapData(String url) {
        try {
            return parseHandiCapData(JsoupUtil.getDocumentByURI(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static List<HandiCap> parseHandiCapData(Document document) {
        Elements postItems = document.select("tr");
        return postItems.stream()
                .map((element -> {
                    Elements elements = element.select("td");
                    if (elements.size() == 7 &&
                            ("早".equals(elements.get(6).text().trim())
                                    || "即".equals(elements.get(6).text().trim()))) {
                        HandiCap handiCap = new HandiCap();
                        handiCap.setHomeName(elements.get(2).text().trim());
                        handiCap.setCap(elements.get(3).text().trim());
                        handiCap.setGuestName(elements.get(4).text().trim());
                        handiCap.setChangeTime(elements.get(5).text().trim());
                        handiCap.setState(elements.get(6).text().trim());
                        return handiCap;
                    } else {
                        return null;
                    }
                }))
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

    private List<HandiCap> queryHandiCap(long matchId, long companyId) {
        try {
            Document document = JsoupUtil.getDocumentByURI(
                    QIUTAN_MATCH_URL + matchId + "&companyid=" + companyId + "&l=0");
            return parseHandiCap(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static List<OverUnder> parseOverUnder(Document document) {
        Elements postItems = document.select("tr");
        return postItems.stream()
                .map((element -> {
                    Elements elements = element.select("td");
                    if (elements.size() == 7 &&
                            ("早".equals(elements.get(6).text().trim())
                                    || "即".equals(elements.get(6).text().trim()))) {
                        OverUnder overUnder = new OverUnder();
                        overUnder.setHomeName(elements.get(2).text().trim());
                        overUnder.setCap(elements.get(3).text().trim());
                        overUnder.setGuestName(elements.get(4).text().trim());
                        overUnder.setChangeTime(elements.get(5).text().trim());
                        overUnder.setState(elements.get(6).text().trim());
                        return overUnder;
                    } else {
                        return null;
                    }
                }))
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

    private List<HandiCap> parseHandiCap(Document document) {
        Elements postItems = document.select("tr");
        return postItems.stream()
                .map((element -> {
                    Elements elements = element.select("td");
                    if (elements.size() == 7 &&
                            ("早".equals(elements.get(6).text().trim())
                                    || "即".equals(elements.get(6).text().trim()))) {
                        HandiCap handiCap = new HandiCap();
                        handiCap.setHomeName(elements.get(2).text().trim());
                        handiCap.setCap(elements.get(3).text().trim());
                        handiCap.setGuestName(elements.get(4).text().trim());
                        handiCap.setChangeTime(elements.get(5).text().trim());
                        handiCap.setState(elements.get(6).text().trim());
                        return handiCap;
                    } else {
                        return null;
                    }
                }))
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

    private static List<EuropeCap> parseEuropeCap(Document document) {
        Elements postItems = document.select("tr");
        return postItems.stream()
                .map((element -> {
                    Elements elements = element.select("td");
                    if (elements.size() == 5 &&
                            ("(初盘)".equals(elements.get(6).text().trim())
                                    || "即".equals(elements.get(6).text().trim()))) {
                        EuropeCap europeCap = new EuropeCap();
                        europeCap.setHomeName(elements.get(2).text().trim());
                        europeCap.setCap(elements.get(3).text().trim());
                        europeCap.setGuestName(elements.get(4).text().trim());
                        europeCap.setChangeTime(elements.get(5).text().trim());
                        europeCap.setState(elements.get(6).text().trim());
                        return europeCap;
                    } else {
                        return null;
                    }
                }))
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

    private static List<EuropeCap> queryEuropeCap(long matchId, long companyId) {
        try {
            Document document = JsoupUtil.getDocumentByURI(
                    QIUTAN_EUR_URL + matchId + "&companyid=" + companyId + "&l=0");
            return parseEuropeCap(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static List<OverUnder> queryOverUnder(long matchId, long companyId) {
        try {
            Document document = JsoupUtil.getDocumentByURI(
                    QIUTAN_BIG_URL + matchId + "&companyid=" + companyId + "&l=0");
            return parseOverUnder(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<Company> getAllCompanyId(long matchId) {
        try {
            Document document = JsoupUtil.getDocumentByURL(ASIAN_URL + matchId + "&l=0");
            return parseHTMLGetCompanyId(document).orElseGet(Collections::emptyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Optional<List<Company>> parseHTMLGetCompanyId(Document document) {
        Elements postItems = document.select("tbody");
        if (postItems.size() > 0) {
            Elements trEles = postItems.get(0).select("tr");
            if (trEles.size() > 2) {
                trEles.remove(0);
                trEles.remove(0);
                List<Company> companyList = trEles.stream()
                    .map(item -> parseTD(item))
                    .filter(item -> item != null)
                    .collect(Collectors.toList());
                return Optional.ofNullable(companyList);
            }
        }
        return Optional.empty();
    }

    private Company parseTD(Element item) {
        if (!"".equals(item.attr(STYLE_DISPLAY))) {
            return null;
        }
        Elements elements = item.select("td");
        if (elements.size() < 10) {
            return null;
        }
        if (MAX_STR.equals(elements.get(0).text()) || MIN_STR.equals(elements.get(0).text())) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(elements.get(0).text());
        Elements spans = elements.get(1).select("span");
        company.setCompanyId(Longs.tryParse(spans.get(0).attr("companyid")));
        return company;
    }

    private Optional<List<HandiCap>> parseHTML(Document document) {
        return Optional.ofNullable(null);
    }

    public static void main(String[] args) {
        String date = "20201127";
        Match match = new Match();
        match.setMatchId(1953820);
        AsianOdds asianOdds = new QiuTanAsianOdds();
        asianOdds.queryAsianOddsByMatchId(match, date);
    }
}
