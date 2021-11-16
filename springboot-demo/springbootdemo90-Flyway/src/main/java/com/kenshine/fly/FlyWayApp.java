package com.kenshine.fly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 14:39
 * @description：springboot整合FlyWay多数据源配置
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@MapperScan(basePackages = "com.kenshine.fly.mapper")
public class FlyWayApp {
    public static void main(String[] args) {
        SpringApplication.run(FlyWayApp.class,args);
    }
}
