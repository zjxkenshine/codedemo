package com.kenshine.powermock.demo05.service;

import com.kenshine.powermock.common.User;
import com.kenshine.powermock.demo05.dao.UserDao;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 8:40
 * @description：
 * @modified By：
 * @version: $
 */
public class UserService {

    public void saveOrUpdate(User user){
        UserDao userDao = new UserDao();
        if(userDao.getCount(user)>0){
            userDao.updateUser(user);
        }else{
            userDao.insertUser(user);
        }
    }


}
