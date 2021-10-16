package com.kenshine.springdemo01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/16 23:42
 * @description：热部署学习
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class LoadController {

    @RequestMapping("/hi")
    public String showMsg(){
        return "热部署测试3";
    }

}
