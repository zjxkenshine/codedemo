package com.kenshine.jasypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 22:57
 * @description：springboot整合Jasypt
 * @modified By：
 * @version: $
 *
 * @EnableEncryptableProperties 数据库加密功能
 */
@SpringBootApplication
@EnableEncryptableProperties
public class JasyptApp {

    public static void main(String[] args) {
        SpringApplication.run(JasyptApp.class,args);
    }

}
