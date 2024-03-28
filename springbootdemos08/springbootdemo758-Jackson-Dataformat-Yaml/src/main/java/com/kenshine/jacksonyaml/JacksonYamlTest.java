package com.kenshine.jacksonyaml;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JacksonYamlTest
 * @Description 测试
 * @Date 2024-03-28 10:03
 * @modified By：
 * @version: 1.0$
 */
public class JacksonYamlTest {

    /**
     * 对象与yaml字符串互转
     */
    @Test
    public void test01(){
        // 1、准备 Java 对象
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        User user = new User("kenshine", 20, Arrays.asList("睡觉", "打游戏"), map);
        // 2、Java 对象转 yaml 字符串
        String toYaml = YamlUtil.toYaml(user);
        System.out.println(toYaml);
        // 3、yaml 字符串转 Java 对象
        User toObject = YamlUtil.toObject(toYaml, User.class);
        System.out.println(toObject);

    }

    /**
     * 对象与yaml文件互转
     */
    @Test
    public void test02() throws IOException {
        // 1、准备 Java 对象
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        User user = new User("kenshine", 20, Arrays.asList("睡觉", "打游戏"), map);
        // 2、转换并输出到文件
        YamlUtil.toYamlFile(user,new File("yaml\\test.yaml"));
        // 3、读取并设置转换为java对象
        User user1 = YamlUtil.toObjectFile(new File("yaml\\test.yaml"),User.class);
        System.out.println(user1);
    }


}
