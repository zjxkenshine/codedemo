package com.kenshine.csrf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author kenshine
 * 用户操作
 */
@Controller
public class LoginController {

    @GetMapping("/userLogin")
    public String login() {
        return "login/login";
    }

    @GetMapping("/toUpdate")
    public String test() {
        return "csrf/updateUser";
    }

    @PostMapping("/updatePassword")
    public String getToken(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        System.out.println("修改密码成功");
        return "csrf/updateSuccess";
    }
}