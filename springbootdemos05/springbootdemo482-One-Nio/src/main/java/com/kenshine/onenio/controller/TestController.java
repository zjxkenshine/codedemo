package com.kenshine.onenio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-11-14 17:07
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    @GetMapping("/test01")
    public String test01(){
        return "kenshine";
    }

}
