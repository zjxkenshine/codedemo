package com.kenshine.autolog.controller;

import com.kenshine.autolog.service.UserService;
import com.kenshine.autolog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-11-06 8:52
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/test01")
    public String test01(){
        return userService.queryLog("1");
    }
}
