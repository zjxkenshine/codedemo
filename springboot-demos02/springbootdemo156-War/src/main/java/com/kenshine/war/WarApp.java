package com.kenshine.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 15:32
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class WarApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WarApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WarApp.class);
    }
}
