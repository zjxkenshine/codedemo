package com.kenshine.filestorage;

import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname XfsApp
 * @Description x-file-storage 使用测试工程
 * @Date 2023-12-09 11:01
 * @modified By：
 * @version: 1.0$
 */
@EnableFileStorage
@SpringBootApplication
public class XfsApp {
    public static void main(String[] args) {
        SpringApplication.run(XfsApp.class,args);
    }
}
