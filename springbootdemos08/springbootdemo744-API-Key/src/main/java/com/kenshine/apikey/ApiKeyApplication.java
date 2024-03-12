package com.kenshine.apikey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

/**
 * @author by kenshine
 * @Classname ApiKeyApplication
 * @Description ApiKey示例
 * @Date 2024-03-12 9:08
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class ApiKeyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiKeyApplication.class,args);
    }
}
