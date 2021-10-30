package com.kenshine.jwt.service;

import com.kenshine.jwt.entity.User;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 9:07
 * @description：用户接口
 * @modified By：
 * @version: $
 */
public interface UserService {
    User login(User user);//登录接口
}
