package com.kenshine.pagehelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 8:23
 * @description：springboot整合PageHelper
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.kenshine.**.mapper"})
public class PageHelperApp {
    public static void main(String[] args) {
        SpringApplication.run(PageHelperApp.class,args);
    }
}
