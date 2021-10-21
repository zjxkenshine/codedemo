package com.kenshine.service;

import com.kenshine.generator.tables.pojos.User;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 9:29
 * @description：用户接口
 * @modified By：
 * @version: $
 */
public interface UserService {


    /**
     * 删除
     */
    void delete(int id);

    /**
     * 增加
     */
    void insert(User user);

    /**
     * 更新
     */
    int update(User user);

    /**
     * 查询单个
     */
    User selectById(int id);

    /**
     * 查询全部列表
     */
    List<User> selectAll(int pageNum, int pageSize);

}
