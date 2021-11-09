package com.kenshine.influxdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 15:17
 * @description：时序数据库App
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class InfluxDBApp {

    public static void main(String[] args) {
        SpringApplication.run(InfluxDBApp.class,args);
    }

}
