package com.kenshine.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 16:30
 * @description：DruidApp测试
 * @modified By：
 * @version: $
 *
 * druid监控地址
 * localhost:8080/druid/
 */
@SpringBootApplication
public class DruidApp {
    public static void main(String[] args) {
        SpringApplication.run(DruidApp.class,args);
    }
}
