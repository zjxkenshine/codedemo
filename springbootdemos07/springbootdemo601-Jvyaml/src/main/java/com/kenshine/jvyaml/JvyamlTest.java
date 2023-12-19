package com.kenshine.jvyaml;

import org.junit.Test;
import org.jvyaml.YAML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JvyamlTest
 * @Description Jvyaml使用测试
 * @Date 2023-12-19 12:26
 * @modified By：
 * @version: 1.0$
 */
public class JvyamlTest {

    /**
     * 基本使用 load
     */
    @Test
    public void test01() throws FileNotFoundException {
        // 不能有注释
       Map<String,String> map= (Map<String, String>) YAML.load(new InputStreamReader(new FileInputStream("src\\main\\resources\\test01.yaml")));
       System.out.println(map);
    }




}
