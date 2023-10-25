package com.kenshine.cosid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname CosidApp
 * @Description 测试id
 * @Date 2023-10-25 9:38
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@MapperScan("com.kenshine.cosid.mapper")
public class CosidApp {
    public static void main(String[] args) {
        SpringApplication.run(CosidApp.class,args);
    }
}
