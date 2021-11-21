package com.kenshine.trans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/21 19:42
 * @description：Spring中的事务
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class TransactionApp {
    public static void main(String[] args) {
        //1.初始化
        SpringApplication application=  new SpringApplication(TransactionApp.class);

        //2.添加数据源
        Map<String,Object> map = new HashMap<>();
        map.put("spring.datasource.url","jdbc:mysql://localhost:3306/db3?characterEncoding=utf8&serverTimezone=GMT&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&useSSL=false");
        map.put("spring.datasource.username","root");
        map.put("spring.datasource.password","zjx123456");

        //3.开启驼峰映射 (Such as account_id ==> accountId)
        map.put("mybatis.configuration.map-underscore-to-camel-case",true);
        application.setDefaultProperties(map);

        //4.启动应用
        application.run(args);
    }
}
