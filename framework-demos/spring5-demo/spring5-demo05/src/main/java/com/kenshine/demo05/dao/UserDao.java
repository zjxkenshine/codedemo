package com.kenshine.demo05.dao;

import org.springframework.stereotype.Repository;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 22:47
 * @description：
 * @modified By：
 * @version: $
 */
@Repository
public interface UserDao {

    void reduceMoney();
    void addMoney();
}
