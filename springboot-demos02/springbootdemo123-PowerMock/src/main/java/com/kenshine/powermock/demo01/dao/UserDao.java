package com.kenshine.powermock.demo01.dao;

import com.kenshine.powermock.common.User;
import org.springframework.stereotype.Component;

/**
 * 模拟不可用的UserDao
 * @author ：kenshine
 * @date ：Created in 2021/11/29 8:40
 * @description：
 * @modified By：
 * @version: $
 */
public class UserDao {

    public int getCount(){
        throw new UnsupportedOperationException();
    }

    public void insertUser(User user){
        throw new UnsupportedOperationException();
    }

}