package com.kenshine.smartdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 8:22
 * @description：
 * @modified By：
 * @version: $
 *
 * 1. 执行maven插件 smart-doc:html
 * 2. 启动项目，访问http://localhost:8080/doc/api.html
 */
@SpringBootApplication
public class SmartDocApp {

    public static void main(String[] args) {
        SpringApplication.run(SmartDocApp.class,args);
    }

}
