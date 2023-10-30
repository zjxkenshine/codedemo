package com.kenshine.mcache.controller;

import com.kenshine.mcache.service.DemoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 控制器
 * @Date 2023-10-30 9:02
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private DemoServiceImpl demoService;

    @GetMapping("/get")
    public String get(){
        return demoService.query1("1");
    }

    @GetMapping("/update")
    public void update(){
        demoService.update("1","kenshine");
    }
}
