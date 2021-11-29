package com.kenshine.powermock.demo04.service;

import com.kenshine.powermock.common.User;
import com.kenshine.powermock.demo04.dao.UserDao;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 8:40
 * @description：
 * @modified By：
 * @version: $
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public int queryUserCount(){
        return userDao.getCount();
    }

    public void saveUser(User user){
        userDao.insertUser(user);
    }

}
