package com.kenshine;

import org.apache.shiro.spring.boot.autoconfigure.ShiroAnnotationProcessorAutoConfiguration;
import org.apache.shiro.spring.boot.autoconfigure.ShiroAutoConfiguration;
import org.apache.shiro.spring.boot.autoconfigure.ShiroBeanAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 9:58
 * @description：Shiro整合测试App
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@MapperScan(value = "com.kenshine.mapper")
public class ShiroApp {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApp.class,args);
    }
}
