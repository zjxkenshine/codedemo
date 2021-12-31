package com.kenshine.responsewrapper.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 21:55
 * @description：测试ResponseWrapper
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/test")
public class TestRespWrapperController {

    @GetMapping("/test01")
    public String test01(){
        return "test01 success!";
    }

    @GetMapping("/test02")
    public String test02(){
        return "test02 success!";
    }
}
