/*
 * Copyright (c) 2020
 * User:jan
 * File:OverFootball.java
 * Date:2020/11/29 19:38:29
 */

package football.over;

import football.model.Match;

import java.util.List;

/**
 * @author: janliao
 * @createTime: 2020/11/29 19:38
 * @version: 1.0
 */
public interface OverFootball {
    public List<Match> queryMatchsByDate(String date);
}
