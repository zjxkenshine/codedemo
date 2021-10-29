package com.kenshine.mapper;

import com.kenshine.entity1.Perms;
import com.kenshine.entity1.User;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 12:03
 * @description：dao接口
 * @modified By：
 * @version: $
 */
public interface UserDAO {

    void save(User user);

    //根据身份信息认证的方法
    User findByUserName(String username);

    //根据用户名查询所有角色
    User findRolesByUserName(String username);
    //根据角色id查询权限集合
    List<Perms> findPermsByRoleId(String id);

}
