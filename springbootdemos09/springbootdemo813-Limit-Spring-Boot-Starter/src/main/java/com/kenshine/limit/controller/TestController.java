package com.kenshine.limit.controller;

import idea.verlif.spring.limit.anno.Limit;
import idea.verlif.spring.limit.impl.DefaultNotArrivedHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kenshine
 * 测试Controller
 */
@RestController
@RequestMapping
public class TestController {


    /**
     * localhost:8080/test01
     */
    @Limit(key = "test01", handler = DefaultLimitHandler.class)
    @GetMapping("/test01")
    public String test1() {
        return "test01";
    }

    /**
     * localhost:8080/test02
     */
    @Limit(key = "test02", handler = DefaultLimitHandler.class)
    @GetMapping("/test02")
    public String test02() {
        return "test02";
    }

    public String test() {
        return "test";
    }
}