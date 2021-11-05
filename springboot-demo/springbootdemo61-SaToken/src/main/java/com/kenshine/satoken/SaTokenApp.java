package com.kenshine.satoken;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 15:33
 * @description：SaTokenApp启动类
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class SaTokenApp {

    public static void main(String[] args) {
        SpringApplication.run(SaTokenApp.class,args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
