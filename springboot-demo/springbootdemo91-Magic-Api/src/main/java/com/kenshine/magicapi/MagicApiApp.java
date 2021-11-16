package com.kenshine.magicapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 21:45
 * @description：Springboot整合MagicApi
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@EnableSwagger2
public class MagicApiApp {

    public static void main(String[] args) {
        SpringApplication.run(MagicApiApp.class,args);
    }

}
