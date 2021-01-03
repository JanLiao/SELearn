/*
 * Copyright (c) 2020
 * User:jan
 * File:QiuTanOverFootball.java
 * Date:2020/11/29 20:08:29
 */

package football.over;

import com.google.common.primitives.Longs;
import football.model.Match;
import football.util.JsoupUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author jan
 * @since 2020/11/29 20:08
 */
public class QiuTanOverFootball implements OverFootball {
    private static final String QIUTAN_MATCH_URL = "http://bf.win007.com/football/Over_";
    private static final int TBODY_NUM = 2;
    private static final String STYLE_DISPLAY = "style";

    @Override
    public List<Match> queryMatchsByDate(String date) {
        try {
            Document document = JsoupUtil.getDocumentByURI(QIUTAN_MATCH_URL + date + ".htm");
            return parseHTML(document).orElseGet(Collections::emptyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Optional<List<Match>> parseHTML(Document document) {
        Elements ps = document.select("tbody");
        Elements postItems = ps.get(ps.size() - 1).select("tr");
        postItems.remove(0);
        List<Match> matchList = postItems.stream()
            .map(item -> parseTD(item)).filter(item -> item != null).collect(Collectors.toList());
        return Optional.ofNullable(matchList);
    }

    private Match parseTD(Element item) {
        if (!"".equals(item.attr(STYLE_DISPLAY))) {
            return null;
        }
        Elements elements = item.select("td");
        if (elements.size() < 10) {
            return null;
        }
        String matchId = elements.get(9).html().split("AsianOdds\\(")[1].split("\\)")[0];
        Match match = new Match.Builder()
                .setMatchId(Longs.tryParse(matchId))
                .setLeague(elements.get(0).text())
                .setMatchTime(elements.get(1).text())
                .setHomeName(elements.get(3).text())
                .setFullScore(elements.get(4).text())
                .setGuestName(elements.get(5).text())
                .setMediumScore(elements.get(6).text())
                .setAsianOdds(elements.get(7).text())
                .setBigOdds(elements.get(8).text())
                .builder();
        return match;
    }
}
