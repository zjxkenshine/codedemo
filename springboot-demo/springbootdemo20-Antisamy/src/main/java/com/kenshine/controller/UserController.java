package com.kenshine.controller;

import com.kenshine.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 8:30
 * @description：用户接口
 * @modified By：
 * @version: 1.0$
 */
@RequestMapping("/user")
@RestController
public class UserController {

    /**
     * 测试http://localhost:8080/user/save
     *
     * id 1<script>alert("XSS");</script>0
     * username ken<script>alert("XSS");</script>shine
     * password 123456
     * @param user
     * @return
     */
    @PostMapping("/save")
    public User saveUser(User user) {
        return user;
    }

    @GetMapping("/get")
    public User getUserById(@RequestParam(value = "id") Long id) {
        return new User(id, "kenshine", "123456");
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return user;
    }

}
