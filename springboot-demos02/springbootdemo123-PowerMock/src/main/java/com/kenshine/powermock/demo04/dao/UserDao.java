package com.kenshine.powermock.demo04.dao;

import com.kenshine.powermock.common.User;

/**
 * 模拟不可用的UserDao
 * @author ：kenshine
 * @date ：Created in 2021/11/29 8:40
 * @description：
 * @modified By：
 * @version: $
 */
final public class UserDao {

    public int getCount(){
        throw new UnsupportedOperationException();
    }

    public void insertUser(User user){
        throw new UnsupportedOperationException();
    }

}
