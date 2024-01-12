package com.kenshine.jsonverifier.controller;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname UserController
 * @Description 测试controller
 * @Date 2024-01-12 14:59
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        User user = new User();
        if(id==1){
            user.setId(1);
            user.setName("kenshine");
        }else{
            user.setId(0);
            user.setName("admin");
        }
        return user;
    }
}
