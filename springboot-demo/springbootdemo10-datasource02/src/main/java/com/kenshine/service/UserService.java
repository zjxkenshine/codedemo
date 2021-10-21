package com.kenshine.service;

import com.kenshine.entity.User;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:24
 * @description：用户接口
 * @modified By：
 * @version: $
 */
public interface UserService {
    List<User> findAll();
}
