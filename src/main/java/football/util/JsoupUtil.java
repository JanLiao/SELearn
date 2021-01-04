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
import java.util.concurrent.TimeUnit;

/**
 * author: janliao
 * createTime: 2020/11/29 18:35
 * version: 1.0
 */
public class JsoupUtil {
    public static Document getDocumentByURL(String url) throws IOException {
        return  Jsoup.parse(new URL(url).openStream(), "GBK", url);
    }

    public static Document getDocumentByURI(String url) throws IOException {
        System.out.println(url);
        Document document = JsoupUtil.getDocumentByURL(url);
        while (document.toString().length() < 20) {
            try {
                TimeUnit.MILLISECONDS.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            document = JsoupUtil.getDocumentByURL(url);
        }
        return document;
    }
}
