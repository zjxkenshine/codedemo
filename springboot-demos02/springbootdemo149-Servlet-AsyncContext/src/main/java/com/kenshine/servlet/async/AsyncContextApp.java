package com.kenshine.servlet.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 23:00
 * @description：测试AsyncContext
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.kenshine.servlet.async.web")
public class AsyncContextApp {
    public static void main(String[] args) {
        SpringApplication.run(AsyncContextApp.class,args);
    }

}
