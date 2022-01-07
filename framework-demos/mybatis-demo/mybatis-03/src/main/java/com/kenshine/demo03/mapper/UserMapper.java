package com.kenshine.demo03.mapper;

import com.kenshine.demo03.pojo.User;

import java.util.List;

/**
 * @author kenshine
 * 用户Mapper
 */
public interface UserMapper {
    /**
     * 获取用户列表
     *
     * @return List<User> 用户列表
     */
    List<User> getUserList();


    /**
     * 根据ID查询用户
     * @param id 用户id
     * @return User 用户信息
     */
    User getUserById(int id);


}
