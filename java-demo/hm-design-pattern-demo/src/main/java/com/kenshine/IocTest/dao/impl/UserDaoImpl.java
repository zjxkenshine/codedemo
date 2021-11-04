package com.kenshine.IocTest.dao.impl;

import com.kenshine.IocTest.dao.UserDao;

/**
 * @version v1.0
 * @ClassName: UserDaoImpl
 * @Description: 数据访问层实现类
 * @Author: kenshine
 */
public class UserDaoImpl implements UserDao {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDaoImpl() {
        System.out.println("userDao被创建了");
    }

    @Override
    public void add() {
        System.out.println("UserDao ..." + username + "==" + password);
    }
}
