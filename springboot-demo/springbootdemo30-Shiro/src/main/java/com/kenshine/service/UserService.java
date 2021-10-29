package com.kenshine.service;

import com.kenshine.entity1.Perms;
import com.kenshine.entity1.User;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 12:07
 * @description：用户接口
 * @modified By：
 * @version: $
 */
public interface UserService {
    //注册用户方法
    void register(User user);

    //根据用户名查询业务的方法
    User findByUserName(String username);

    //根据用户名查询所有角色
    User findRolesByUserName(String username);

    //根据角色id查询权限集合
    List<Perms> findPermsByRoleId(String id);
}
