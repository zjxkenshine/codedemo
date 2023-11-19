package com.kenshine.hawtio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/19 17:59
 * @description：测试Controller
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
       return "test";
    }
}
