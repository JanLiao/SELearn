/*
 * Copyright (c) 2020
 * User:jan
 * File:MybatisUtil.java
 * Date:2020/12/24 23:28:24
 */

package football.util;

import java.io.IOException;
import java.io.Reader;

import football.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author jan
 * @since 2020/12/24 23:28
 */
public class MybatisUtil {
    SqlSessionFactory sessionFactory = null;
    SqlSession sqlSession = null;

    {
        String resource = "./mybatis-config.xml";
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
        UserDao mapper = new MybatisUtil().sqlSession.getMapper(UserDao.class);
    }
}
