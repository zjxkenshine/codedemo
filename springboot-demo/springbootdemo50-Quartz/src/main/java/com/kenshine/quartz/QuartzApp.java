package com.kenshine.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 15:50
 * @description：Quartz启动类
 * @modified By：
 * @version: $
 *
 * 测试的时候主线程一直开着才有效果
 */
@SpringBootApplication
public class QuartzApp {

    public static void main(String[] args) {
        SpringApplication.run(QuartzApp.class,args);
    }

}
