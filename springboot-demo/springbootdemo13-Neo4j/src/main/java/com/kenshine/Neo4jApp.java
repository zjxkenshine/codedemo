package com.kenshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 8:58
 * @description：Neo4j启动类
 * @modified By：
 * @version: $
 *
 */
@SpringBootApplication
public class Neo4jApp {
    public static void main(String[] args) {
        SpringApplication.run(Neo4jApp.class,args);
    }
}
