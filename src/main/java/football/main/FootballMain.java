/*
 * Copyright (c) 2021
 * User:jan
 * File:FootballMain.java
 * Date:2021/01/02 17:00:02
 */

package football.main;

import football.dao.MatchDao;
import football.model.Match;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * @author jan
 * @since 2021/1/2 17:00
 */
public class FootballMain {
    private static SqlSessionFactory sessionFactory = null;
    private static SqlSession sqlSession = null;

    static {
        String resource = "football/util/mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sessionFactory.openSession(true);
    }

    public static void main(String[] args) {
        MatchDao matchDao = FootballMain.sqlSession.getMapper(MatchDao.class);
        List<Match> matchList = new ArrayList<>();
        Match match = new Match();
        match.setMatchId(12500);
        matchList.add(match);
        matchDao.insertMatchList(matchList);
    }
}
