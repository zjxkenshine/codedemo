package com.kenshine.bucket4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/24 6:48
 * @description：Springboot整合Bucket4j
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@EnableCaching
public class Bucket4jApp {
    public static void main(String[] args) {
        SpringApplication.run(Bucket4jApp.class,args);
    }
}
