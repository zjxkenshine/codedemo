package com.kenshine.jpa.web;

import com.kenshine.jpa.domain.User;
import com.kenshine.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 11:11
 * @description：用户接口
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user2")
public class User2Controller {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    /**
     * 注意:记得添加@RequestBody注解,否则前端传递来的json数据无法被封装到User中!
     */
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return  userRepository.save(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        return "success";
    }

}
