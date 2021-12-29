package com.kenshine.typesafe.test01;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 9:31
 * @description：
 * @modified By：
 * @version: $
 */
public class test01 {
    public static void main(String[] args) {
        Config config = ConfigFactory.parseFile(new File(test01.class.getClassLoader().getResource("test01/app.conf").getPath()));
        //ConfigBeanFactory将Config转换为JavaBean
        AppConfig appConfig = ConfigBeanFactory.create(config, AppConfig.class);
        String name = appConfig.getDemo().getName();
        System.out.println("Name:" + name);
        System.out.println(appConfig);
    }

}
