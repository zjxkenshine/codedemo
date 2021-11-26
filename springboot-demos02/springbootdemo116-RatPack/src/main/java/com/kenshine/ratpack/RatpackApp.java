package com.kenshine.ratpack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ratpack.spring.config.EnableRatpack;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 9:48
 * @description：
 * @modified By：
 * @version: $
 *
 * 启动项目，访问localhost:5050可以得到 Hello World
 * 方案二：在Springboot中嵌入RatPack
 */
@SpringBootApplication
@EnableRatpack
public class RatpackApp {

    public static void main(String[] args) {
        SpringApplication.run(RatpackApp.class, args);
    }

}
