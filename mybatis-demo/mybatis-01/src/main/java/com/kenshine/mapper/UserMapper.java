package com.kenshine.mapper;

import com.kenshine.pojo.User;

import java.util.List;

/**
 * @author kenshine
 * 用户Mapper
 */
public interface UserMapper {
    /**
     * 获取用户列表
     * @return List<User> 用户列表
     */
    List<User> getUserList();

}
