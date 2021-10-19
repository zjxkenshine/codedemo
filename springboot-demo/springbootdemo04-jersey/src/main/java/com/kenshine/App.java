package com.kenshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 17:02
 * @description：启动类
 * @modified By：
 * @version: $
 *
 *
 * 关于注册方式
 * Jersey和Springboot的集成有两种方式，一种是使用Filter的方式注册，一种是使用Servlet的方式注册，
 * 默认使用的是Servlet的方式，也可以通过spring.jersey.type=filter或者通过spring.jersey.type=servlet来控制
 *
 *
 *
 *
 */
@SpringBootApplication
public class App {


    /**
     * 第二种方式，使用@Bean创建一个ResourceConfig类实例
     */
//    @Bean
//    public ResourceConfig resourceConfig() {
//        ResourceConfig config = new ResourceConfig();
//        config.register(HelloResource.class);
//        return config;
//    }

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }

}
