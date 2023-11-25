package com.kenshine.gracefulresponse;

import com.feiniaojin.gracefulresponse.EnableGracefulResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname GrApp
 * @Description GracefulResponse App
 * @Date 2023-11-24 13:53
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableGracefulResponse
public class GrApp {
    public static void main(String[] args) {
        SpringApplication.run(GrApp.class,args);
    }
}
