package com.kenshine.quickperflive.controller;

import org.quickperf.annotation.MeasureExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试controller
 * @Date 2023-12-07 9:07
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * 测试controller
     */
    @GetMapping("/test01")
    public String test01(){
        List<String> list = Arrays.asList("a","b","c","d");
        System.out.println(list);
        return "test01";
    }
}
