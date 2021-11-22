package com.kenshine.urulec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/22 10:01
 * @description：Urule客户端应用
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@ImportResource({"classpath:urule-core-context.xml"})
public class UruleClientApp {
    public static void main(String[] args) {
        SpringApplication.run(UruleClientApp.class,args);
    }
}
