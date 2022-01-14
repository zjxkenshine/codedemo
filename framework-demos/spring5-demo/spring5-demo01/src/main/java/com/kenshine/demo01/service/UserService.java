package com.kenshine.demo01.service;

import com.kenshine.demo01.dao.UserDao;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/14 22:06
 * @description：
 * @modified By：
 * @version: $
 */
public class UserService {

    //创建UserDao类型属性，生成set方法
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add...............");
        userDao.update();//调用dao方法
    }
}
