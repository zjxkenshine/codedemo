package com.kenshine.allatori.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2024-04-22 14:31
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    /**
     * localhost:8080
     */
    @GetMapping("/test")
    public String test(){
        return "hello allatori";
    }
}
