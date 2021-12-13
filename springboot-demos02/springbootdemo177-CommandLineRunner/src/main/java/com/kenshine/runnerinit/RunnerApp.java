package com.kenshine.runnerinit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 22:44
 * @description：初始化
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class RunnerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RunnerApp.class,args);

        //参数
        ApplicationArguments applicationArguments = context.getBean(ApplicationArguments.class);
        System.out.println("============");
        System.out.println("name="+applicationArguments.getOptionNames());
        System.out.println("values===="+applicationArguments.getOptionValues("developer.name"));
    }
}
