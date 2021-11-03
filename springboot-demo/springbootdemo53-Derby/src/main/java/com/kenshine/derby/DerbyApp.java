package com.kenshine.derby;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 21:32
 * @description：derby整合
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@MapperScan("com.kenshine.derby.mapper")
public class DerbyApp {

    public static void main(String[] args) {
        SpringApplication.run(DerbyApp.class,args);
    }

}
