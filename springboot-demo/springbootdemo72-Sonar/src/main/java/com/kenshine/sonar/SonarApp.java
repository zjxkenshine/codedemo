package com.kenshine.sonar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 9:17
 * @description：整合Sonar代码质量检测
 * @modified By：
 * @version: $
 *
 * 主要是IDEA插件 与java代码无关
 */
@SpringBootApplication
public class SonarApp {

    public static void main(String[] args) {
        SpringApplication.run(SonarApp.class,args);
    }

}
