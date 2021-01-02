/*
 * Copyright (c) 2020
 * User:jan
 * File:ParseDocument.java
 * Date:2020/12/11 22:45:11
 */

package football.util;

import football.model.HandiCap;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jan
 * @since 2020/12/11 22:45
 */
public class ParseDocument<T> {
    private T t;

    public List<HandiCap> parseHandiCap(Document document) {
        Elements postItems = document.select("tr");
        postItems.forEach(System.out::println);
        return postItems.stream()
                .map((element -> {
                    Elements elements = element.select("td");
                    if (elements.size() == 7 &&
                            ("早".equals(elements.get(6).text().trim())
                                    || "(初盘)".equals(elements.get(6).text().trim())
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
}
