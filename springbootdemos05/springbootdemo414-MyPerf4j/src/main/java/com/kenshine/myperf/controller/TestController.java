package com.kenshine.myperf.controller;

import com.kenshine.myperf.utils.TestUtil;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-10-26 14:28
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public void test(){
        System.out.println("执行了test");
    }

    @GetMapping("/test1")
    public void test1() throws InterruptedException {
        System.out.println("开始执行test1");
        TestUtil.sleep();
        System.out.println("test1执行完毕");
    }


}
