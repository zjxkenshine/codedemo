package com.kenshine.memcached;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/14 19:30
 * @description：启动类
 * @modified By：
 * @version: $
 *
 * Springboot整合MemCached,两种客户端
 * - xmemcached
 * - spymemcached
 */
@SpringBootApplication
public class MemApp {
    public static void main(String[] args) {
        SpringApplication.run(MemApp.class,args);
    }
}
