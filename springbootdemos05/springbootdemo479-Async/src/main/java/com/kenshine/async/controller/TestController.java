package com.kenshine.async.controller;

import com.github.houbb.async.core.model.async.AsyncResult;
import com.github.houbb.async.core.proxy.AsyncProxy;
import com.kenshine.async.service.UserService;
import com.kenshine.async.service.UserServiceDefault;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/12 22:06
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Resource
    private UserService userServiceDefault;

    /**
     * 请求一次
     * 异步无效
     */
    @GetMapping("/test")
    public void test(){
        long start = System.currentTimeMillis();
        AsyncResult<String> result = userServiceDefault.queryUser("123");
        AsyncResult<String> result2 = userServiceDefault.queryUser("1234");

        System.out.println("查询结果" + result.getResult());
        System.out.println("查询结果" + result2.getResult());
        long end = System.currentTimeMillis();
        System.out.println("共计耗时: " + (end-start));
    }

    /**
     * 请求两次
     * 异步有效
     */
    @GetMapping("/test1")
    public void test01(){
        userServiceDefault.queryUser("123");
    }
    @GetMapping("/test2")
    public void test02(){
        userServiceDefault.queryUser("1234");
    }


    /**
     * 未使用代理
     * 异步无效
     */
    @Test
    public void test2(){
        UserServiceDefault userServiceDefault1=new UserServiceDefault();
        long start = System.currentTimeMillis();
        AsyncResult<String> result = userServiceDefault1.queryUser("123");
        AsyncResult<String> result2 = userServiceDefault1.queryUser("1234");

        System.out.println("查询结果" + result.getResult());
        System.out.println("查询结果" + result2.getResult());
        long end = System.currentTimeMillis();
        System.out.println("共计耗时: " + (end-start));
    }

    /**
     * 动态代理
     * 异步有效
     */
    @Test
    public void test3(){
        long start = System.currentTimeMillis();
        UserService userService = new UserServiceDefault();
        UserService userServiceProxy = (UserService) AsyncProxy.getProxy(userService);
        AsyncResult<String> result = userServiceProxy.queryUser("123");
        AsyncResult<String> result2 = userServiceProxy.queryUser("1234");

        System.out.println("查询结果" + result.getResult());
        System.out.println("查询结果" + result2.getResult());
        long end = System.currentTimeMillis();
        System.out.println("共计耗时: " + (end-start));
    }
}
