package com.kenshine.idgen2.controller;

import com.kenshine.idgen2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-10-18 16:51
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test01")
    public void test01(){
        testService.test01();
    }
}
