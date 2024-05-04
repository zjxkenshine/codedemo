package com.kenshine.converter;

import com.github.liaochong.converter.annoation.EnableConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname ConverterApp
 * @Description 转换
 * @Date 2024-05-04 13:57
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableConverter
public class ConverterApp {
    public static void main(String[] args) {
        SpringApplication.run(ConverterApp.class, args);
    }
}
