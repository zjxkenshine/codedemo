package com.kenshine.web;

import com.kenshine.domain.User;
import com.kenshine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 9:01
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{id}")
    public String saveUser(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("qin");
        user.setSex("女");
        userRepository.save(user);
        return "success";
    }


    @GetMapping("/list")
    public List<User> getUser() {
        return userRepository.findAll();
    }
}
