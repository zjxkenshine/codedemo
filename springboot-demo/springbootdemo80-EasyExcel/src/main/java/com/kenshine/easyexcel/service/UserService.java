package com.kenshine.easyexcel.service;

import com.kenshine.easyexcel.domain.User;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 16:38
 * @description：用户业务接口
 * @modified By：
 * @version: 1.0$
 */
public interface UserService {
    /**
     *  查询所有用户信息
     */
    List<User> getAll();

    /**
     * 保存用户信息
     */
    void saveBatch(List<User> list);
}
