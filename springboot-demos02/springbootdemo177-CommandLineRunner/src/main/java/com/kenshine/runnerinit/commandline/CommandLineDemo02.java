package com.kenshine.runnerinit.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 22:50
 * @description：读取参数
 * @modified By：
 * @version: $
 */
@Order(2)
@Component
public class CommandLineDemo02 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===========CommandLineDemo02启动了================");
        System.out.println("=====启动参数====="+ Arrays.asList(args));
    }
}
