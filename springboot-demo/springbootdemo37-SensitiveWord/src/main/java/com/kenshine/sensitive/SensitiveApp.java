package com.kenshine.sensitive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 23:07
 * @description：敏感词过滤启动类
 * @modified By：
 * @version: $
 *
 * @TODO 自定义实现敏感词过滤
 */
@SpringBootApplication
public class SensitiveApp {

    public static void main(String[] args) {
        SpringApplication.run(SensitiveApp.class,args);
    }

}
