package com.kenshine.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 8:55
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        System.out.println("method in controller");
        return "test1";
    }


}
