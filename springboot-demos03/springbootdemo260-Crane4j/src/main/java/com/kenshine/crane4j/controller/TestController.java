package com.kenshine.crane4j.controller;

import com.kenshine.crane4j.domain.Foo;
import com.kenshine.crane4j.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2023-10-16 9:37
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("/test/test01")
    public void test01(){
        testService.test01();
    }

    @GetMapping("/test/test02")
    public void test02(){
        // 自动填充
        List<Foo> list=testService.test02();
        System.out.println("自动填充"+list);
    }
}
