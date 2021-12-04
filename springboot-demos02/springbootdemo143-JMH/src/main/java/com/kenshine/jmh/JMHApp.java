package com.kenshine.jmh;

import com.alibaba.fastjson.JSON;
import com.kenshine.jmh.model.User;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/4 9:40
 * @description：JMH测试App
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class JMHApp {
    public static void main(String[] args) {
        SpringApplication.run(JMHApp.class,args);
    }
}
