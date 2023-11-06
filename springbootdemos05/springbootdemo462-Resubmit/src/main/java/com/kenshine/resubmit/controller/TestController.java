package com.kenshine.resubmit.controller;

import com.github.houbb.resubmit.api.exception.ResubmitException;
import com.kenshine.resubmit.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-11-06 12:04
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private UserService userService;

    @GetMapping("/test")
    public String queryTest() {
        try {
            userService.queryInfo("1");
            //userService.queryInfo("1");
            return "成功";
        }catch (ResubmitException e){
            return "信息重复提交";
        }
    }
}
