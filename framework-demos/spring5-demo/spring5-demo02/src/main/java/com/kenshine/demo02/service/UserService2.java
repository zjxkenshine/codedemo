package com.kenshine.demo02.service;

import com.kenshine.demo02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/14 23:57
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class UserService2 {
    //定义 dao 类型属性
    //不需要添加 set 方法
    //添加注入属性注解
    @Autowired
    //根据名称进行注入（目的在于区别同一接口下有多个实现类，根据类型就无法选择，从而出错！）
    @Qualifier(value = "userDaoImpl1")
    private UserDao userDao;

    public void add() {
        System.out.println("service add.......");
        userDao.add();
    }

}
