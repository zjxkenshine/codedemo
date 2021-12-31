package com.kenshine.wrapper.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 9:45
 * @description：Xss测试
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/test")
public class XssTestController {

    /**
     * post localhost:8080/test/test01
     * "<script>alert('password')</script>xss测试"
     */
    @PostMapping("/test01")
    public void test01(@RequestBody String str){
        System.out.println(str);
    }

    /**
     * post localhost:8080/test/test02
     * "<script>alert('password')</script>xss测试"
     */
    @PostMapping("/test02")
    public void test02(@RequestBody String str){
        System.out.println(str);
    }
}
