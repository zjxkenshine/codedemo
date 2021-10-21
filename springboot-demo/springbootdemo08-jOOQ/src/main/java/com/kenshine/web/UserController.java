package com.kenshine.web;

import com.kenshine.generator.tables.pojos.User;
import com.kenshine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 9:34
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }

    @GetMapping("/list")
    public List<User> getUserList() {
        return userService.selectAll(10,1);
    }
}
