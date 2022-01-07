package com.kenshine.demo01.mapper;

import com.kenshine.demo01.pojo.User;

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
     * 根据ID查询用户
     * @param id 用户id
     * @return User 用户信息
     */
    User getUserById(int id);

    /**
     * 根据ID查询用户 Map版本，不推荐
     * @param map 查询map
     * @return User
     */
    User getUserById2(Map<String,Object> map);

    /**
     * 模糊查询1 value要带%
     * @param value 字段
     * @return User 用户
     */
    List<User> getUserLike(String value);

    /**
     * 模糊查询2 value不带%
     * @param value 字段
     * @return User 用户
     */
    List<User> getUserLike2(String value);

    /**
     * 添加用户
     * @param user 用户
     * @return int
     */
    int addUser(User user);

    /**
     * 添加用户Map,不推荐使用Map
     * @param map 用户map
     * @return int
     */
    int addUser2(Map<String,Object> map);

    /**
     * 修改用户
     * @param user 用户
     * @return id
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return id
     */
    int deleteUser(int id);



}
