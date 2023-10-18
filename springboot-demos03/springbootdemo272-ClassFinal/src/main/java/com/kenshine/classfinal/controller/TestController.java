package com.kenshine.classfinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试加密
 * @Date 2023-10-18 11:53
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @GetMapping("/test01")
    public void test01(){
        System.out.println("1111111");
    }

    @GetMapping("/test02")
    public String test02(){
        System.out.println("kenshine");
        return "kenshine";
    }
}
