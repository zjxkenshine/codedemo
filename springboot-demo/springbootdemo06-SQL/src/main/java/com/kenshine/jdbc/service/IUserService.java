package com.kenshine.jdbc.service;

import com.kenshine.jdbc.domain.User;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 10:30
 * @description：用户业务接口
 * @modified By：
 * @version: $
 */
public interface IUserService {

    int add(User user);

    int update(User user);

    int delete(int id);

    User findUserById(int id);

    List<User> findUserList();

}
