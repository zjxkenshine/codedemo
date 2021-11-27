package com.kenshine.plumeloglite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/27 8:19
 * @description：
 * @modified By：
 * @version: $
 *
 * TODO 待配置：链路追踪，扩展字段等 lite版本没有监控报警功能
 */
@SpringBootApplication
@ComponentScan("com.plumelog")
@ComponentScan("com.kenshine.plumeloglite")
public class PlumeLogLiteApp {

    public static void main(String[] args) {
        SpringApplication.run(PlumeLogLiteApp.class,args);
    }

}
