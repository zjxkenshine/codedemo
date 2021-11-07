package com.kenshine.p6spy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/7 23:04
 * @description：整合P6spy启动类
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@MapperScan(basePackages = "com.kenshine.p6spy.mapper")
public class P6spyApp {

    public static void main(String[] args) {
        SpringApplication.run(P6spyApp.class,args);
    }

}
