package com.kenshine.beecp;

import cn.beecp.boot.EnableDsMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname BeecpApp
 * @Description Beecp测试
 * @Date 2023-11-03 8:06
 * @modified By：
 * @version: 1.0$
 */
@EnableDsMonitor
@SpringBootApplication
public class BeecpApp {
    public static void main(String[] args) {
        SpringApplication.run(BeecpApp.class);
    }
}
