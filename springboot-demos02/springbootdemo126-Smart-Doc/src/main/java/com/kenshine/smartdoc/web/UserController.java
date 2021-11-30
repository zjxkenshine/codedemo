package com.kenshine.smartdoc.web;

import com.kenshine.smartdoc.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 8:37
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public User getUser(@RequestBody User user) {
        return new User();
    }

}
