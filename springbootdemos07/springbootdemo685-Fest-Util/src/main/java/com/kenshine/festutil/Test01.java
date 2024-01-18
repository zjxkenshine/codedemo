package com.kenshine.festutil;

import org.fest.util.Arrays;
import org.fest.util.Collections;
import org.fest.util.Files;
import org.fest.util.SystemProperties;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description fest util使用示例
 * @Date 2024-01-18 16:02
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {

    /**
     * Arrays 数组相关
     */
    @Test
    public void test01(){
        // 生成数组
        Integer[] a=Arrays.array(1,2,3,4,5);
        // 转字符串
        String s=Arrays.format(a);
        System.out.println(s);
    }

    /**
     * 集合相关
     */
    @Test
    public void test02(){
        // 重复的元素
        Collection<Integer> collection =Collections.duplicatesFrom(java.util.Arrays.asList(1,2,2,3,4,5));
        String s=Collections.format(collection);
        System.out.println(s);
    }

    @Test
    public void test03(){
        System.out.println(SystemProperties.LINE_SEPARATOR);
    }

    /**
     * Files工具类
     */
    @Test
    public void test04() throws IOException {
        Files.newFolder("file");
        Files.newFile("file\\test01.txt");
        System.out.println(Files.currentFolder().getAbsolutePath());
        FileWriter fileWriter = new FileWriter("file\\test01.txt");
        fileWriter.append('k');
        fileWriter.append('e');
        fileWriter.append('n');
        Files.flushAndClose(fileWriter);
    }

}
