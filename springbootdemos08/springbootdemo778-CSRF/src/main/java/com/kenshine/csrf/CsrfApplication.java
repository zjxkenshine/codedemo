package com.kenshine.csrf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname CsrfApplication
 * @Description CSRF跨站请求伪造
 * @Date 2024-04-19 8:27
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
public class CsrfApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsrfApplication.class,args);
    }
}
