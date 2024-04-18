package com.kenshine.xss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname XssApplication
 * @Description springboot防护xss攻击
 * @Date 2024-04-18 8:15
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
public class XssApplication {
    public static void main(String[] args) {
        SpringApplication.run(XssApplication.class,args);
    }
}
