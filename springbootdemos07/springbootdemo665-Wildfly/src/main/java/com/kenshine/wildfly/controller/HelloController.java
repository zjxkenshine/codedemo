package com.kenshine.wildfly.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试controller
 * @author kenshine
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public Map<String, String> hello(){
        HashMap<String, String> map = new HashMap<>();
        map.put("server","wildfly");
        map.put("msg","springboot deploy by jboss wildfly");
        return map;
    }
}