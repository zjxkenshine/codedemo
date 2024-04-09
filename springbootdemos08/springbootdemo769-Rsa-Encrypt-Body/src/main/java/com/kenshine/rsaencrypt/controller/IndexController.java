package com.kenshine.rsaencrypt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author by kenshine
 * @Classname IndexController
 * @Description 跳转
 * @Date 2024-04-09 10:52
 * @modified By：
 * @version: 1.0$
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        System.out.println("跳转index");
        return "index";
    }
}
