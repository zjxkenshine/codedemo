package com.kenshine.referer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试controller
 * @Date 2024-04-19 9:36
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * post:localhost:8080/test01
     */
    @PostMapping("/test01")
    public Map<String,String> test01(){
        System.out.println("成功");
        Map<String,String> map = new HashMap<>(8);
        map.put("msg","成功");
       return map;
    }
}
