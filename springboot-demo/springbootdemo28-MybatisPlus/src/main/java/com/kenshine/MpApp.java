package com.kenshine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 9:57
 * @description：SpringBoot整合MybatisPlus
 * @modified By：
 * @version: $
 * //@MapperScan：扫描mapper接口所在包
 */
@SpringBootApplication
@MapperScan("com.kenshine.mapper")
public class MpApp {
    public static void main(String[] args) {
        SpringApplication.run(MpApp.class,args);
    }

}
