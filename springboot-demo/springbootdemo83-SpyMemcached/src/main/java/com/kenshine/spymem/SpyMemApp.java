package com.kenshine.spymem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/14 20:39
 * @description：Springboot整合Memcache方式二
 * @modified By：
 * @version: 1.0$
 *
 * 参考地址
 * https://blog.csdn.net/xhf852963/article/details/100099986
 */
@SpringBootApplication
public class SpyMemApp {

    public static void main(String[] args) {
        SpringApplication.run(SpyMemApp.class,args);
    }

}
