package com.kenshine.sisyphus.controller;

import com.kenshine.sisyphus.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试重试
 * @Date 2023-11-08 12:12
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private SpringService service;

    @GetMapping("/test01")
    public String test01(){
        return service.query();
    }

    @GetMapping("/test02")
    public String test02(){
        return "kenshine";
    }
}
