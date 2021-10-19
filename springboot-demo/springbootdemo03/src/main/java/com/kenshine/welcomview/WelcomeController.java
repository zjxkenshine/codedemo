package com.kenshine.welcomview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 9:39
 * @description：欢迎页
 * @modified By：
 * @version: $
 * 配置欢迎页方式一：视图控制器配置欢迎页
 * 配置欢迎页方式二：Controller直接实现方式
 */
@Controller
public class WelcomeController {

//    @RequestMapping("/")
//    public String view() {
//        System.out.println("Controller方式");
//        return "forward:home.html";
//    }

    /**
     * themleaf配置
     * @return
     */
    @RequestMapping("/")
    public String login() {
        return "login";
    }
}
