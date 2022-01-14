package com.kenshine.demo02.dao;

import org.springframework.stereotype.Repository;

//Dao实现类
//@Repository
@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add.....");
    }
}