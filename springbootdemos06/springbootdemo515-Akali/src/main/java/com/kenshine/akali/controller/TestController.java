package com.kenshine.akali.controller;

import com.kenshine.akali.model.User;
import com.kenshine.akali.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 使用测试
 * @Date 2023-11-30 9:04
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("/test01")
    public User test01(){
        return testService.getUser(1);
    }

    @GetMapping("/test02")
    public User test02(){
        return testService.getUser1(1);
    }

    @GetMapping("/test03")
    public String test03(){
        return testService.sayHi2("kenshine");
    }

}
