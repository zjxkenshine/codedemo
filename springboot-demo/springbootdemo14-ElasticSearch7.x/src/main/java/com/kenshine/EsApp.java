package com.kenshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 11:05
 * @description：elasticsearch启动类
 * @modified By：
 * @version: $
 *
 * 说明：
 *  test包：使用原生RestHighLevelClient测试
 *  main包：使用ElasticsearchRestTemplate测试
 */
@SpringBootApplication
public class EsApp {

    public static void main(String[] args) {
        SpringApplication.run(EsApp.class,args);
    }

}
