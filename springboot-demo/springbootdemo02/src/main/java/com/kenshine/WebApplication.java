package com.kenshine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 9:18
 * @description：web项目
 * @modified By：
 * @version: 1.0$
 */
/**
 * 扫描Mapper
 */
@MapperScan("com.kenshine.*.mapper")
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args){
        SpringApplication.run(WebApplication.class,args);
    }
}
