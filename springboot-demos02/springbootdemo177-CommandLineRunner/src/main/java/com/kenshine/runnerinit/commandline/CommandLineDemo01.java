package com.kenshine.runnerinit.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 22:49
 * @description：
 * @modified By：
 * @version: $
 * 多个CommandLineRunner使用@Order指定顺序，越小的先执行
 */
@Order(1)
@Component
public class CommandLineDemo01 implements CommandLineRunner {
    //可以注入一些Bean

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===========CommandLineDemo01启动了================");
    }
}
