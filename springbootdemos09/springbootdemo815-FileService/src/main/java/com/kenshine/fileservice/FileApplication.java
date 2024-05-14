package com.kenshine.fileservice;

import idea.verlif.spring.file.EnableFileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * @author by kenshine
 * @Classname FileApplication
 * @Description file文件管理
 * @Date 2024-05-14 13:59
 * @modified By：
 * @version: 1.0$
 */
@EnableFileService
@SpringBootApplication
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

    /**
     * 修改临时路径 方式2
     */
//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation("D:\Github\codedemo\springbootdemos09\springbootdemo815-FileService");
//        return factory.createMultipartConfig();
//    }
}
