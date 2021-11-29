package com.kenshine.powermock.demo07;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 11:03
 * @description：
 * @modified By：
 * @version: $
 */
public class UserService {

    public String queryByName(String name){
        UserDao userDao = new UserDao();
        return userDao.queryByName(name);
    }

}
