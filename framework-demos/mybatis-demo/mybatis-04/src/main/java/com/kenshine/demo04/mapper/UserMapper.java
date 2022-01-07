package com.kenshine.demo04.mapper;


import com.kenshine.demo04.pojo.User;

import java.util.List;
import java.util.Map;

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

    /**
     * 分页
     * @param map
     * @return
     */
    List<User> getUserByLimit(Map<String, Integer> map);

    /**
     * RowBounds分页
     * 不建议使用
     */
    List<User> getUserByRowBounds();
}
