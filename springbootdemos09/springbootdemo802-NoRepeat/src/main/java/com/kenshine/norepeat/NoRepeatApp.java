package com.kenshine.norepeat;

import idea.verlif.spring.norepeat.EnableNoRepeat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname NoRepeatApp
 * @Description 防重复提交
 * @Date 2024-05-07 17:33
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableNoRepeat
public class NoRepeatApp {
    public static void main(String[] args) {
        SpringApplication.run(NoRepeatApp.class, args);
    }
}
