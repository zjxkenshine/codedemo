package com.kenshine.perf4j.controller;

import com.kenshine.perf4j.service.TestService;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-10-26 11:49
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("/test")
    public void test(){
        testService.test01();
    }

}
