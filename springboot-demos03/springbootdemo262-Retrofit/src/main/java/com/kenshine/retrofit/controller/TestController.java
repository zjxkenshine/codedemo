package com.kenshine.retrofit.controller;

import com.kenshine.retrofit.domain.TestEntity;
import com.kenshine.retrofit.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 23:16
 * @description： 测试类
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("/test01")
    public void test01(){
        // 调用 GET localhost:8080/server/test01
        testService.test01();
    }

    @GetMapping("/test02")
    public void test02(){
        // 调用 POST localhost:8080/server/postList
        List<TestEntity> testEntityList= testService.test02();
        System.out.println(testEntityList);
    }

    @GetMapping("/test03")
    public void test03(){
        // 调用 Get localhost:8080/server/entity/{id}
        List<TestEntity> testEntityList= testService.test03();
        System.out.println(testEntityList);
    }

    @GetMapping("/test04")
    public void test04(){
        // 调用 Get localhost:8080/server/getList
        List<TestEntity> testEntityList= testService.test04();
        System.out.println(testEntityList);
    }

    @GetMapping("/test05")
    public void test05(){
        // 调用 Get localhost:8080/server/getHeader
        testService.test05();
    }
}
