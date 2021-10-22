package com.kenshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 15:10
 * @description：MongoDb启动类
 * @modified By：
 * @version: $
 *
 * 传统的关系数据库一般由数据库(database)、表(table)、记录(record)三个层次概念组成，
 * 而MongoDB是由数据库(database)、集合(collection)、文档对象(document)三个层次组成。
 * MongoDB中的collection对应了关系型数据库里的表，但是集合中没有列、行和关系概念，这体现了模式自由的特点
 *
 */
@SpringBootApplication
public class MongoApp {
    public static void main(String[] args) {
        SpringApplication.run(MongoApp.class,args);
    }
}
