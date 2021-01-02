/*
 * Copyright (c) 2020
 * User:jan
 * File:UserDao.java
 * Date:2020/05/31 23:56:31
 */

package football.dao;

/** 
* @author ����: JanLiao
* @date ʱ��: 2020��5��11�� ����9:22:44
*/

import java.util.List;

import football.model.Users;
import org.apache.ibatis.annotations.Param;


public interface UserDao {

    public int insert(Users user);

    public int update(Users user);

    public int delete(int id);

    public Users getById(int id);

    public List<Users> getAll();
    
    public Users getUser(@Param("name") String name);

    public List<Users> getLikeUser(@Param("name") String name);
}
