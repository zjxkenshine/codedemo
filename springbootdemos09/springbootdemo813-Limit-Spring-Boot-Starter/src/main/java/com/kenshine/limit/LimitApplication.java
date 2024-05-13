package com.kenshine.limit;

import idea.verlif.spring.limit.EnableLimit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname LimitApplication
 * @Description 限制测试项目
 * @Date 2024-05-13 13:53
 * @modified By：
 * @version: 1.0$
 */
@EnableLimit
@SpringBootApplication
public class LimitApplication {
    public static void main(String[] args) {
        SpringApplication.run(LimitApplication.class,args);
    }
}
