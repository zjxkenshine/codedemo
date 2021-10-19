package com.kenshine.message.controller;

import com.kenshine.message.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 8:34
 * @description：用户Controller
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Object getList() {
        List<User> list = new ArrayList<>();
        //测试字符串有null的情况
        User u1 = new User("kenshine", "浙江温州");
        list.add(u1);
        return list;
    }

}
