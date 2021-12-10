package com.kenshine.gson.web;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 10:13
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public User get() {
        User user = new User();
        user.setUsername("kenshine");
        user.setAge(25);
        user.setBirthday(new Date());
        return user;
    }

    @Data
    private static class User {
        private String username;
        private Date birthday;
        private Integer age;
    }

}
