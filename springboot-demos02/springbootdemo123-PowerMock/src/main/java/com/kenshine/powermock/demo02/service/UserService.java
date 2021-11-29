package com.kenshine.powermock.demo02.service;

import com.kenshine.powermock.common.User;
import com.kenshine.powermock.demo02.dao.UserDao;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 8:40
 * @description：
 * @modified By：
 * @version: $
 */
public class UserService {

    public int queryUserCount(){
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void saveUser(User user){
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }


}
