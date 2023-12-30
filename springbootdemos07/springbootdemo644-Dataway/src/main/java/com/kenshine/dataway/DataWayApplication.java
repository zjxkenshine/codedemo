package com.kenshine.dataway;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author by kenshine
 * @Classname DataWayApplication
 * @Description 整合dataway
 * @Date 2023-12-30 16:56
 * @modified By：
 * @version: 1.0$
 */
@EnableHasor // 在Spring 中启用 Hasor
@EnableHasorWeb //将 hasor-web 配置到 Spring 环境中，Dataway 的 UI 是通过 hasor-web 提供服务
@SpringBootApplication(scanBasePackages = { "com.kenshine.dataway"})
public class DataWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataWayApplication.class);
    }
}
