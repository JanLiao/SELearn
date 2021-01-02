/*
 * Copyright (c) 2020
 * User:jan
 * File:JsoupUtil.java
 * Date:2020/11/29 18:35:29
 */

package football.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * author: janliao
 * createTime: 2020/11/29 18:35
 * version: 1.0
 */
public class JsoupUtil {
    public static Document getDocumentByURL(String url) throws IOException {
        return  Jsoup.parse(new URL(url).openStream(), "GBK", url);
    }
}
