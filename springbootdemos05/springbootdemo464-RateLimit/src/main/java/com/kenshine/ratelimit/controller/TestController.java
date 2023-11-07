package com.kenshine.ratelimit.controller;

import com.github.houbb.rate.limit.core.core.RateLimits;
import com.kenshine.ratelimit.service.UserService;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-11-08 8:22
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private UserService userService;

    @GetMapping("/test01")
    public String test01(){
       return userService.limitCount();
    }


}
