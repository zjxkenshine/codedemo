package com.kenshine.configyml.config;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/25 11:02
 * @description：测试
 * @modified By：
 * @version: $
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/property/resource")
@PropertySource(name = "demo113.yml", value = "classpath:demo113.yml", factory = MixPropertySourceFactory.class)
public class test {

    @Value("${person.kenshine.age}")
    private int age;

    @GetMapping
    public String testPropertyResource() {
        System.out.println("kenshine年龄：" + age);
        return "success";
    }

}
