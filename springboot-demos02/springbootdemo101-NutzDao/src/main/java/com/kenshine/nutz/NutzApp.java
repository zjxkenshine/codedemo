package com.kenshine.nutz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/19 9:15
 * @description：Springboot整合NutzDao
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class NutzApp {
    public static void main(String[] args) {
        SpringApplication.run(NutzApp.class,args);
    }

    @RestController
    class TestRest{
        @GetMapping("/test")
        public String test(){
            return "测试一下！";
        }
    }
}
