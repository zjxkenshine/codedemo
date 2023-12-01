package com.kenshine.jflex.simple;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author by kenshine
 * @Classname test01
 * @Description 使用测试
 * @Date 2023-12-01 14:35
 * @modified By：
 * @version: 1.0$
 */
public class test01 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "springbootdemo519-JFlex/src/main/java/com/kenshine/jflex/simple/lang.l";
        MyParser parser = new MyParser(new MyScanner(new FileReader(fileName)));
        try {
//			parser.parse();
            parser.debug_parse();
        }
        catch (Exception e) {
            System.out.println("Caught an exception.");
        }
    }
}
