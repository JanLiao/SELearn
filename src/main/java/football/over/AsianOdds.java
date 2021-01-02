/*
 * Copyright (c) 2020
 * User:jan
 * File:AsianOdds.java
 * Date:2020/12/01 08:08:01
 */

package football.over;

import football.model.HandiCap;
import football.model.Match;

import java.util.List;

/**
 * @author jan
 * @since 2020/12/1 8:08
 */
public interface AsianOdds {
    /**
     * 用于查询比赛亚盘
     * @param matchId 比赛ID
     */
    public List<HandiCap> queryAsianOddsByMatchId(Match match, String date);
}
