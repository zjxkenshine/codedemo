package com.kenshine.querydsl.controller;

import com.kenshine.querydsl.entity.People;
import com.kenshine.querydsl.service.PeopleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 23:35
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@RestController
public class PeopleController {
    @Resource
    PeopleService peopleService;

    /**
     * 测试地址
     * http://localhost:8080/selectById
     * 先添加id为0的数据
     * @return
     */
    @RequestMapping("/selectById")
    public People selectById(){
        return peopleService.selectOne(0);
    }

}
