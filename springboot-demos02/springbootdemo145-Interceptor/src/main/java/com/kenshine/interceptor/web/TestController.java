package com.kenshine.interceptor.web;

import com.kenshine.interceptor.annotation.TestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 12:09
 * @description：
 * @modified By：
 * @version: $
 * 拦截器
 */
@RestController
public class TestController {

    @GetMapping("/test/test01")
    @TestMethod
    public String test01(){
        return "success";
    }


    /**
     * 不含@TestMethod注解，会被拒绝
     * @return
     */
    @GetMapping("/test/test02")
    public String test02(){
        return "success";
    }

    /**
     * 不走testMethod拦截器
     * @return
     */
    @GetMapping("/login/test")
    public String test03(){
        return "success";
    }

}
