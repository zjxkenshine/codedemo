package com.kenshine.sureness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author by kenshine
 * @Classname SureApplication
 * @Description sureness程序
 * @Date 2023-10-11 15:08
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@ServletComponentScan
public class SureApplication {
    public static void main(String[] args) {
        SpringApplication.run(SureApplication.class, args);
    }
}
