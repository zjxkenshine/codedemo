package com.kenshine.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 10:06
 * @description：跳转到Index
 * @modified By：
 * @version: $
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("跳转至主页");
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("跳转至登录页");
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        System.out.println("跳转至注册页");
        return "register";
    }

}
