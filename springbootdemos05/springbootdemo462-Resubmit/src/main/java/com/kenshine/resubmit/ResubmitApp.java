package com.kenshine.resubmit;

import com.github.houbb.resubmit.spring.annotation.EnableResubmit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname ResubmitApp
 * @Description App
 * @Date 2023-11-06 12:02
 * @modified By：
 * @version: 1.0$
 */
@EnableResubmit
@SpringBootApplication
public class ResubmitApp {
    public static void main(String[] args) {
        SpringApplication.run(ResubmitApp.class,args);
    }
}
