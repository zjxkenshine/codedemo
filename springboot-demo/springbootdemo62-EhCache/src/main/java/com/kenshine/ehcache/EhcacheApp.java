package com.kenshine.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 21:26
 * @description：Ehcache整合
 * @modified By：
 * @version: $
 *
 * 开启缓存
 */
@EnableCaching
@SpringBootApplication
public class EhcacheApp {

    public static void main(String[] args) {
        SpringApplication.run(EhcacheApp.class,args);
    }

}
