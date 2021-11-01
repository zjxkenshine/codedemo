package com.kenshine.tess4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 22:15
 * @description：Springboot整合tess4j实现ocr
 * @modified By：
 * @version: $
 *
 * https://github.com/tesseract-ocr/tesseract
 */
@SpringBootApplication
public class Tess4jApp {

    public static void main(String[] args) {
        SpringApplication.run(Tess4jApp.class,args);
    }

}
