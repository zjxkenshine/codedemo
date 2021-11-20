package com.kenshine.caffeinecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/20 8:54
 * @description： springboot整合CaffeineCache
 * @modified By：
 * @version: $
 *
 * 注意需要 @EnableCaching 注解
 */
@EnableCaching
@SpringBootApplication
public class CaffeineCacheApp {

    public static void main(String[] args) {
        SpringApplication.run(CaffeineCacheApp.class,args);
    }

}
