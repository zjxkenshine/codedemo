package com.kenshine.hasorweb;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname HasorApp
 * @Description hasor使用
 * @Date 2023-12-30 15:49
 * @modified By：
 * @version: 1.0$
 */
@EnableHasor
@EnableHasorWeb
@SpringBootApplication
public class HasorApp {
    public static void main(String[] args) {
        SpringApplication.run(HasorApp.class,args);
    }
}
