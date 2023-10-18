package com.kenshine.ipLimit1;

import com.van.limiter.core.annotation.EnableIpLimit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname ipLimit1App
 * @Description 测试
 * @Date 2023-10-18 17:35
 * @modified By：
 * @version: 1.0$
 *
 * @EnableIpLimit 开启ip限流
 */
@SpringBootApplication
@EnableIpLimit
public class ipLimit1App {
    public static void main(String[] args) {
        SpringApplication.run(ipLimit1App.class);
    }
}
