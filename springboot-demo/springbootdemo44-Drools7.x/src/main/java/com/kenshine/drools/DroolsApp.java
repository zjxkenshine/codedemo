package com.kenshine.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 14:04
 * @description：规则引擎Drools简单整合
 * @modified By：
 * @version: $
 *
 * @TODO WorkBench的使用 决策表的使用
 * 其他规则引擎 如 alibaba qlExpress，iLog， VisualRules
 */
@SpringBootApplication
public class DroolsApp {

    public static void main(String[] args) {
        SpringApplication.run(DroolsApp.class,args);
    }

}
