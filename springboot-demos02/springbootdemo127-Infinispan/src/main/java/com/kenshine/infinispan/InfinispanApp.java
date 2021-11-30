package com.kenshine.infinispan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 8:57
 * @description：
 * @modified By：
 * @version: $
 *
 * TODO 远程方式(HOT DOT)和集群
 */
@SpringBootApplication
@EnableCaching
public class InfinispanApp {
    public static void main(String[] args) {
        SpringApplication.run(InfinispanApp.class,args);
    }
}
