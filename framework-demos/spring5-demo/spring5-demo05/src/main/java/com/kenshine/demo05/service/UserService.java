package com.kenshine.demo05.service;

import com.kenshine.demo05.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 22:47
 * @description：
 * @modified By：
 * @version: $
 */
@Service
@Transactional
public class UserService {
    //注入 dao
    @Autowired
    private UserDao userDao;


    public void transferMoney(){
        //减少
        userDao.reduceMoney();
        //模拟异常
        int i = 100/0;
        //增加
        userDao.addMoney();
    }

}
