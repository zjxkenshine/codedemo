package com.kenshine.permission.controller;

import idea.verlif.spring.permission.anno.Perm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2024-05-17 10:34
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * 测试，获取用户信息
     * localhost:8080/test01
     */
    @Perm(hasRole = "user")
    @GetMapping("/test01")
    public String selfInfo(){
        return "success";
    }
}
