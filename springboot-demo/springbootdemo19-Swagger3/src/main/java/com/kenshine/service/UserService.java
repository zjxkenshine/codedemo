package com.kenshine.service;

import com.kenshine.domain.CommonResult;
import com.kenshine.domain.User;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 16:16
 * @description：用户接口
 * @modified By：
 * @version: $
 */
public interface UserService {
    /**
     * 保存用户
     *
     * @param user 用户参数
     * @return CommonResult<User>
     */
    CommonResult<User> saveUser(User user);

    /**
     * 查询所有用户
     *
     * @return CommonResult<List<User>>
     */
    CommonResult<List<User>> findUserAll();

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return CommonResult<User>
     */
    CommonResult<User> findUserById(Long id);

    /**
     * 根据id更新用户
     *
     * @param user 用户参数
     * @return CommonResult<User>
     */
    CommonResult<User> updateUserById(User user);

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return CommonResult<User>
     */
    CommonResult<User> deleteUserById(Long id);

    /**
     * 删除所有用户
     *
     * @return CommonResult<List<User>>
     */
    CommonResult<List<User>> deleteUserAll();
}
