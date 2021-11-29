package com.kenshine.powermock.demo03.dao;

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

    public static int getCount(){
        throw new UnsupportedOperationException();
    }

    public static void insertUser(User user){
        throw new UnsupportedOperationException();
    }

}
