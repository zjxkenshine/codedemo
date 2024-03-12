package com.kenshine.apikey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试数据
 * @Date 2024-03-12 9:22
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String homeEndpoint() {
        return "Success !";
    }
}
