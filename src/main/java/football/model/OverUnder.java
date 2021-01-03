/*
 * Copyright (c) 2020
 * User:jan
 * File:overUnder.java
 * Date:2020/12/10 00:40:10
 */

package football.model;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author jan
 * @since 2020/12/10 0:40
 */
@Data
public class OverUnder {
    private String homeName;
    private String cap;
    private String guestName;
    private String changeTime;
    private String state;

    public String parseObject() {
        String hn = null == homeName ? "" : homeName;
        String cp = null == cap ? "" : cap;
        String gn = null == guestName ? "" : guestName;
        String ct = null == changeTime ? "" : changeTime;
        String st = null == state ? "" : state;
        List<String> objectList = Arrays
                .asList(hn, cp, gn, ct, st);
        return String.join(",", objectList);
    }
}
