package com.kenshine.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 10:46
 * @description：Spring Profile学习
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class ProfileApp {
    public static void main(String[] args) {
        SpringApplication.run(ProfileApp.class,args);
    }
}
