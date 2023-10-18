package com.kenshine.idgen2;

import com.lxm.idgenerator.EnableIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname IdGen2App
 * @Description 测试
 * @Date 2023-10-18 16:39
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableIdGenerator
public class IdGen2App {
    public static void main(String[] args) {
        SpringApplication.run(IdGen2App.class, args);
    }
}
