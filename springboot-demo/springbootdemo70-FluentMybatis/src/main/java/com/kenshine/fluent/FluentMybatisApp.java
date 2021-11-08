package com.kenshine.fluent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 22:45
 * @description：FluentMybatisApp示例
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@MapperScan("com.kenshine.fluent.mapper")
public class FluentMybatisApp {

    public static void main(String[] args) {
        SpringApplication.run(FluentMybatisApp.class,args);
    }

}
