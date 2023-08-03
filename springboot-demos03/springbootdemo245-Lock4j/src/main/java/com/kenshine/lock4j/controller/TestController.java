package com.kenshine.lock4j.controller;

import com.kenshine.lock4j.domain.User;
import com.kenshine.lock4j.service.XlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-08-03 19:52
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Autowired
    private XlService xlService;


    @GetMapping("test")
    public void test(){
        User user = new User();
        user.setId(1L);
        user.setName("kenshine");
        xlService.test(user);
    }

}
