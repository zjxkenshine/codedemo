package com.kenshine.postprocessor.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 10:35
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/test")
public class TestUserController extends BaseController{
    private int num;

    public TestUserController() {
    }

    public TestUserController(int i) {
        System.out.println("初始化num为"+i);
        this.num=i;
    }

    @GetMapping
    public String test(){
        return "访问成功";
    }

}
