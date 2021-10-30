package com.kenshine.jta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 9:30
 * @description：jta应用
 * @modified By：
 * @version: $
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JtaApp {
    public static void main(String[] args) {
        SpringApplication.run(JtaApp.class,args);
    }
}
