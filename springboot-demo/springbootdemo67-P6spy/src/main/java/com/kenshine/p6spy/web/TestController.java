package com.kenshine.p6spy.web;

import com.kenshine.p6spy.entity.User;
import com.kenshine.p6spy.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/7 23:14
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/test")
    public User test01(){
        return userMapper.selectById(2);
    }


}
