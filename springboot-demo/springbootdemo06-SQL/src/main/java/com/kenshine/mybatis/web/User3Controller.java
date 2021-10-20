package com.kenshine.mybatis.web;

import com.kenshine.mybatis.domain.User;
import com.kenshine.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 11:24
 * @description：用户接口3 Mybatis版增删改查
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user3")
public class User3Controller {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userMapper.queryUserById(id);
    }

    @PostMapping("")
    public String addUser(@RequestBody User user) {
        userMapper.insertUser(user);
        return "success";
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user) {
        userMapper.updateUser(user);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delUserById(@PathVariable("id") Integer id) {
        userMapper.deleteById(id);
        return "success";
    }

}
