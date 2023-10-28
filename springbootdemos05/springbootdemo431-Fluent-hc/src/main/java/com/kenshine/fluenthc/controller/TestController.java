package com.kenshine.fluenthc.controller;

import com.kenshine.fluenthc.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-10-28 13:22
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    @GetMapping("/test01")
    public String test01(){
        return "TEST01返回数据";
    }

    @PostMapping("/test02")
    public String test02(@RequestBody User user){
        System.out.println(user);
        return "TEST02返回数据";
    }

}
