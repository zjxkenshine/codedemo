package com.kenshine.wildfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname WildflyApp
 * @Description springboot打包部署到wildfly
 * @Date 2024-01-10 9:28
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
public class WildflyApp {

    public static void main(String[] args) {
        SpringApplication.run(WildflyApp.class,args);
    }

}
