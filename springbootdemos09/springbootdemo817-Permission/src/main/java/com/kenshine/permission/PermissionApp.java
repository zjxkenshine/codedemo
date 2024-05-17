package com.kenshine.permission;

import idea.verlif.spring.permission.anno.EnablePermission;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname PermissionApp
 * @Description 权限
 * @Date 2024-05-17 10:19
 * @modified By：
 * @version: 1.0$
 */
@EnablePermission
@SpringBootApplication
public class PermissionApp {
    public static void main(String[] args) {
        SpringApplication.run(PermissionApp.class, args);
    }
}
