package com.kenshine.mcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author by kenshine
 * @Classname CacheApp
 * @Description 测试
 * @Date 2023-10-30 8:52
 * @modified By：
 * @version: 1.0$
 *
 * ImportResource 引入spring 配置文件
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:cache/applicationContext-cache.xml"})
public class CacheApp {
    public static void main(String[] args) {
        SpringApplication.run(CacheApp.class,args);
    }
}
