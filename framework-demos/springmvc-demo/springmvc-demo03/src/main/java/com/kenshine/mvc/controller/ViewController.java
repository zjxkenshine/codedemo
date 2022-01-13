package com.kenshine.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/13 22:19
 * @description： 视图
 * @modified By：
 * @version: $
 */
@Controller
public class ViewController {

    /**
     * Thymeleaf视图
     */
    @RequestMapping("/testHello")
    public String testHello(){
        return "hello";
    }

    /**
     * 转发视图
     */
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testHello";
    }

    /**
     * 重定向视图
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testHello";
    }

}
