package com.kenshine.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/13 20:48
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        //设置视图名称
        return "index";
    }


}
