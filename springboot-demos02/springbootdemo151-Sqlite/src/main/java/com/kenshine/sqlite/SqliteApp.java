package com.kenshine.sqlite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/6 11:23
 * @description：Springboot整合Sqlite
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@MapperScan({"com.kenshine.sqlite.mapper"})
public class SqliteApp {
    public static void main(String[] args) {
        SpringApplication.run(SqliteApp.class,args);
    }
}
