package com.kenshine.querydsl.service;

import com.kenshine.querydsl.entity.People;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 23:20
 * @description：用户Service
 * @modified By：
 * @version: $
 */
public interface PeopleService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    People selectOne(Integer id);

}
