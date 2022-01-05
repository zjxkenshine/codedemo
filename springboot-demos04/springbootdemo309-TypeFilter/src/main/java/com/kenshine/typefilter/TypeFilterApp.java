package com.kenshine.typefilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 8:38
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication(scanBasePackages ={"com.kenshine.typefilter.demo01","com.kenshine.typefilter.demo02.config"})
public class TypeFilterApp {
    public static void main(String[] args) {
        SpringApplication.run(TypeFilterApp.class,args);
    }
}
