package com.kenshine.liteflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author by kenshine
 * @Classname LiteFlowApp
 * @Description TODO
 * @Date 2023/3/7 13:22
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@ComponentScan({"com.*.liteflow"})
public class LiteFlowApp {
    public static void main(String[] args) {
        SpringApplication.run(LiteFlowApp.class);
    }

}
