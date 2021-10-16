package com.kenshine.springdemo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 关闭自动配置
 * @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 */

@SpringBootApplication
public class Springdemo01Application {

    public static void main(String[] args) {
        //禁用热部署
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Springdemo01Application.class, args);
    }

}
