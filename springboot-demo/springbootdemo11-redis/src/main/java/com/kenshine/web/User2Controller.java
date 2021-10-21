package com.kenshine.web;

import com.kenshine.domain.User;
import com.kenshine.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 18:06
 * @description：用户Controller
 * @modified By：
 * @version: $
 *
 * Redis整合缓存使用
 */
@RestController
@RequestMapping("/user2")
@Slf4j
public class User2Controller {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        //打印hashcode,判断是否是同一对象
        log.warn("user="+user.hashCode());
        HttpStatus status = user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(user, status);
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "ok";
    }

}
