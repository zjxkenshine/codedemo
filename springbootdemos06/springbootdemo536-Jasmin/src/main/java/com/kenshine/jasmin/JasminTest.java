package com.kenshine.jasmin;

import jasmin.Main;
import org.junit.Test;

import java.io.File;

/**
 * @author by kenshine
 * @Classname JasminTest
 * @Description jasmin使用测试
 * @Date 2023-12-04 17:20
 * @modified By：
 * @version: 1.0$
 */
public class JasminTest {

    /**
     * 编译
     * 通过命令
     */
    @Test
    public void test01(){
        // jasmin编译
        Main.main(new String[]{"jasmin", "D:\\Github\\codedemo\\springbootdemos06\\springbootdemo536-Jasmin\\src\\main\\java\\com\\kenshine\\jasmin\\HelloWorld.j"});
    }

    /**
     * jasmin版本
     */
    @Test
    public void test02(){
        System.out.println(Main.version);
    }

    /**
     * assemble 方法编译
     */
    @Test
    public void test03(){
        String file = "D:\\Github\\codedemo\\springbootdemos06\\springbootdemo536-Jasmin\\src\\main\\java\\com\\kenshine\\jasmin\\HelloWorld.j";

        /**
         * 是要放置结果的目录
         * 是包含Jasmin源代码的文件的名称
         * 是否显示行号
         */
        Main.assemble("out", file, true);
    }
}
