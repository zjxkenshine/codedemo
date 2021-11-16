package com.kenshine.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 9:59
 * @description：测试动态数据源
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@MapperScan(basePackages = "com.kenshine.dynamic.mapper")
public class DydsApp {
    public static void main(String[] args) {
        SpringApplication.run(DydsApp.class,args);
    }
}
