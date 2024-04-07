package com.kenshine.proxool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author by kenshine
 * @Classname ProxoolApp
 * @Description Proxool测试工程
 * @Date 2024-04-07 8:47
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@ServletComponentScan
public class ProxoolApp {
    public static void main(String[] args) {
        SpringApplication.run(ProxoolApp.class,args);
    }
}
