package com.kenshine.springdemo07.controller;

import com.kenshine.springdemo07.entity.User;
import com.kenshine.springdemo07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 21:55
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class UserController {
    //注入service
    @Autowired
    private UserService userService;

    //id查询
    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserById(id);
    }

    //查询所有
    @GetMapping("/user")
    public Flux<User> getUsers(){
        return userService.getAllUser();
    }

    //添加用户
    @PostMapping("/saveuser")
    public Mono<Void> setUser(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }

}
