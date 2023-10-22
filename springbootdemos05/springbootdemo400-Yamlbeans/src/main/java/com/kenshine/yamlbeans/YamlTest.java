package com.kenshine.yamlbeans;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/22 15:46
 * @description：测试
 * @modified By：
 * @version: $
 */
public class YamlTest {
    @Test
    public void transform() {
        String path = "test.yaml";
        // 1、准备 Java 对象
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        Cat cat = new Cat("喵喵", 2, Arrays.asList("捉老鼠", "吃鱼"), map);
        // 2、Java 对象写到 yaml 文件
        YamlUtil.writeYaml(cat, path);
        // 3、读取 yaml 文件转成 Java 字符串
        System.out.println(YamlUtil.readYaml(path, Cat.class));
    }
}
