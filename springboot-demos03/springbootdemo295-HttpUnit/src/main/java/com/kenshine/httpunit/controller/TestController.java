package com.kenshine.httpunit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 12:46
 * @description：测试
 * @modified By：
 * @version: $
 */
@Controller
public class TestController {
    @RequestMapping("/test01")
    public String test1(){
        return "table";
    }

    @RequestMapping("/test02")
    public String test2(){
        return "table2";
    }
}
