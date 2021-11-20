package com.kenshine.caffeine.service;

import com.kenshine.caffeine.domain.UserInfo;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/20 8:39
 * @description：用户信息接口
 * @modified By：
 * @version: $
 */
public interface UserInfoService {
    /**
     * 增加用户信息
     *
     * @param userInfo 用户信息
     */
    void addUserInfo(UserInfo userInfo);

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserInfo getByName(Integer id);

    /**
     * 修改用户信息
     *
     * @param userInfo 用户信息
     * @return 用户信息
     */
    UserInfo updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     */
    void deleteById(Integer id);
}
