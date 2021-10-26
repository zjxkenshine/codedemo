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
 * @date ：Created in 2021/10/26 8:50
 * @description：用户接口
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户数据
     * @param user
     * @return
     */
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        //hashcode判断是否是同一对象
        log.warn("user="+user.hashCode());
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(user, status);
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "ok";
    }

}
