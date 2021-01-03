/*
 * Copyright (c) 2021
 * User:jan
 * File:FootballMain.java
 * Date:2021/01/02 17:00:02
 */

package football.main;

import football.dao.MatchDao;
import football.model.Match;
import football.over.AsianOdds;
import football.over.OverFootball;
import football.over.QiuTanAsianOdds;
import football.over.QiuTanOverFootball;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

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

    public static void main(String[] args) throws ParseException {
        // set http proxy
        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "8888");
        // set https proxy
        System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "8888");
        MatchDao matchDao = FootballMain.sqlSession.getMapper(MatchDao.class);
        String dateStart = "20140715";
        String dateEnd="20210102";
        SimpleDateFormat date=new SimpleDateFormat("yyyyMMdd");
        // start
        long startTime = date.parse(dateStart).getTime();
        // end
        long endTime = date.parse(dateEnd).getTime();
        long day=1000*60*60*24;
        for(long i=startTime;i<=endTime;i+=day) {
            String curDate = date.format(new Date(i));
            OverFootball matchs = new QiuTanOverFootball();
            List<Match> matchList = matchs.queryMatchsByDate(curDate);
            System.out.println(curDate + ", " + matchList.size());
            matchList.forEach(match -> {
                System.out.println(match);
                AsianOdds asianOdds = new QiuTanAsianOdds();
                asianOdds.queryAsianOddsByMatchId(match, curDate);
            });
            List<Match> matchList1 = matchList.stream().filter((match -> {
                if (match != null) {
                    return matchDao.queryMatch(String.valueOf(match.getMatchId())) == null;
                }
                return false;
            })).collect(Collectors.toList());
            System.out.println("filter size = " + matchList1.size());
            matchDao.insertMatchList(matchList1);
        }
    }
}
