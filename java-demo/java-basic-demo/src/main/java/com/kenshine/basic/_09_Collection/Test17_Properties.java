package com.kenshine.basic._09_Collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:52
 * @description：Properties 继承于 Hashtable。表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串
 * @modified By：
 * @version: $
 *
 */
public class Test17_Properties {
    public static void main(String[] args) throws IOException {
        String prop= "java-basic-demo\\src\\main\\resources\\jdbc.properties";
        Properties properties=new Properties();
        properties.load((new FileInputStream(prop)));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user", "kenshine");
        System.out.println(url);
        System.out.println(user);
    }
}
