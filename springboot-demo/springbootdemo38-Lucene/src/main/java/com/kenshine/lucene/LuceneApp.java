package com.kenshine.lucene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 8:56
 * @description：Lucene启动类
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.kenshine.lucene.mapper"})
public class LuceneApp {

    public static void main(String[] args) {
        SpringApplication.run(LuceneApp.class,args);
    }

}
