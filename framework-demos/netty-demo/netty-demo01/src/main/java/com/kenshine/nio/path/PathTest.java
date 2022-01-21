package com.kenshine.nio.path;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/21 21:23
 * @description：
 * @modified By：
 * @version: $
 */
public class PathTest {

    @Test
    public void test01(){
        // 相对路径 不带盘符 使用 user.dir 环境变量来定位 1.txt
        Path source = Paths.get("1.txt");
        // 绝对路径 代表了  d:\1.txt 反斜杠需要转义
        Path source1 = Paths.get("d:\\1.txt");
        // 绝对路径 同样代表了  d:\1.txt
        Path source2 = Paths.get("d:/1.txt");
        // 代表了  d:\data\projects
        Path projects = Paths.get("d:\\data", "projects");
    }

    /**
     * 正常化路径
     */
    @Test
    public void test02(){
        Path path = Paths.get("d:\\data\\projects\\a\\..\\b");
        System.out.println(path);
        // 正常化路径 会去除 . 以及 ..
        System.out.println(path.normalize());
    }
}
