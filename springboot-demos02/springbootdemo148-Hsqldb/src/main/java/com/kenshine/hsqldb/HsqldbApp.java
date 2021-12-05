package com.kenshine.hsqldb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 17:32
 * @description：Springboot整合HsqlDB
 * @modified By：
 * @version: 1.0$
 */
@MapperScan(basePackages = "com.kenshine.hsqldb.mapper")
@SpringBootApplication
public class HsqldbApp {

    public static void main(String[] args) {
        SpringApplication.run(HsqldbApp.class,args);
    }

}
