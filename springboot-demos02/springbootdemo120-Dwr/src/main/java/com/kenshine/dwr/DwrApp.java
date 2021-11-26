package com.kenshine.dwr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 22:09
 * @description：DwrApp
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@ImportResource("classpath*:spring/spring.xml")
public class DwrApp {
    public static void main(String[] args) {
        SpringApplication.run(DwrApp.class,args);
    }
}
