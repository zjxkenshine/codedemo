package com.kenshine.jasypt.web;

import com.kenshine.jasypt.entity.User;
import com.kenshine.jasypt.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 23:48
 * @description：用户接口
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    /**
     * 测试加密后是否连通
     * @return
     */
    @GetMapping("/list")
    public List<User> getUserList(){
       return userMapper.getAll();
    }

}
