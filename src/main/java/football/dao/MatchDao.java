/*
 * Copyright (c) 2021
 * User:jan
 * File:MatchDao.java
 * Date:2021/01/02 17:02:02
 */

package football.dao;

import football.model.Match;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jan
 * @since 2021/1/2 17:02
 */
public interface MatchDao {
    public void insertMatchList(@Param("matchList") List<Match> matchList);

    public Match queryMatch(@Param("matchId") String matchId);
}
