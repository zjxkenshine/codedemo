package com.kenshine.applicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 17:00
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class Demo302App {
    public static void main(String[] args) {
        SpringApplication.run(Demo302App.class,args);
    }
}
