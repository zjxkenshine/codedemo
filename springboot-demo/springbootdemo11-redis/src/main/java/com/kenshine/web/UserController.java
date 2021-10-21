package com.kenshine.web;

import com.kenshine.domain.User;
import com.kenshine.repository.UserRepository;
import com.kenshine.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 14:42
 * @description：用户接口
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisService redisService;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        User user = (User) redisService.getObj("user" + id);
        if (user == null) {
            user = userRepository.findById(id).get();
            redisService.setObj("user" + id, user, 1000 * 60 * 2);
            return user;
        }
        return user;
    }

}
