package com.kenshine.rsaencrypt;

import cn.shuibo.annotation.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname RsaApplication
 * @Description RSA加密项目
 * @Date 2024-04-09 9:27
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableSecurity
public class RsaApplication {
    public static void main(String[] args) {
        SpringApplication.run(RsaApplication.class,args);
    }
}
