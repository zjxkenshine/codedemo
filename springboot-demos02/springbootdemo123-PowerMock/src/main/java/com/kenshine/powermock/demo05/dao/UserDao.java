package com.kenshine.powermock.demo05.dao;

import com.kenshine.powermock.common.User;

/**
 * 模拟不可用的UserDao
 * @author ：kenshine
 * @date ：Created in 2021/11/29 8:40
 * @description：
 * @modified By：
 * @version: $
 */
public class UserDao {

    public int getCount(User user){
        throw new UnsupportedOperationException();
    }

    public void updateUser(User user){
        throw new UnsupportedOperationException();
    }

    public void insertUser(User user){
        throw new UnsupportedOperationException();
    }

}
