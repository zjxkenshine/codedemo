package com.kenshine.typesafe.test03;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 10:40
 * @description：测试配置合并
 * @modified By：
 * @version: $
 */
public class test03 {
    public static void main(String[] args) {
        Config config1 = ConfigFactory.parseFile(new File(test03.class.getClassLoader().getResource("test03/test.conf").getPath()));
        Config config2 = ConfigFactory.parseFile(new File(test03.class.getClassLoader().getResource("test03/test.json").getPath()));
        Config config3 = ConfigFactory.parseFile(new File(test03.class.getClassLoader().getResource("test03/test.properties").getPath()));

        Config newConfig = config1.withFallback(config2).withFallback(config3);
        System.out.println(newConfig.getAnyRef("conf.name"));
        System.out.println(newConfig.getAnyRef("properties.name"));
        System.out.println(newConfig.getAnyRef("user"));
    }
}
