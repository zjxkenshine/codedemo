package com.kenshine.jacksonyaml;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/22 14:58
 * @description：
 * @modified By：
 * @version: $
 */
public class YamlTest {
    @Test
    public void transform() {
        // 1、准备 Java 对象
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        Cat cat = new Cat("喵喵", 2, Arrays.asList("捉老鼠", "吃鱼"), map);
        // 2、Java 对象转 yaml 字符串
        String toYaml = YamlUtil.toYaml(cat);
        System.out.println(toYaml);
        // 3、yaml 字符串转 Java 对象
        Cat toObject = YamlUtil.toObject(toYaml, Cat.class);
        System.out.println(toObject);
    }
}
