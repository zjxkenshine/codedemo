package com.kenshine.powermock.demo03.service;

import com.kenshine.powermock.common.User;
import com.kenshine.powermock.demo03.dao.UserDao;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 8:40
 * @description：
 * @modified By：
 * @version: $
 */
public class UserService {

    public int queryUserCount(){
        //模拟静态方法
        return UserDao.getCount();
    }

    public void saveUser(User user){
        UserDao.insertUser(user);
    }


}
