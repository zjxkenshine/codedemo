package com.kenshine.urule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/22 9:03
 * @description：UruleApp
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@ImportResource({"classpath:urule-console-context.xml"})
public class UruleApp {
    public static void main(String[] args) {
        SpringApplication.run(UruleApp.class,args);
    }
}
