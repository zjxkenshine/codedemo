package com.kenshine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 10:02
 * @description：SQLdemo
 * @modified By：
 * @version: $
 *
 * MapperScan 配置扫描的Mapper
 */
@SpringBootApplication
@MapperScan("com.kenshine.*.mapper")
public class SqlApplication {

    public static void main(String[] args){
        SpringApplication.run(SqlApplication.class,args);
    }

}
