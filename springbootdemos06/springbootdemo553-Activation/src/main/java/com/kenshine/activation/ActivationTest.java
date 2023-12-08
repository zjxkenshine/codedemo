package com.kenshine.activation;

import org.junit.Test;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;

/**
 * @author by kenshine
 * @Classname ActivationTest
 * @Description activation测试
 * @Date 2023-12-08 9:18
 * @modified By：
 * @version: 1.0$
 */
public class ActivationTest {

    /**
     * 获取mimeType
     */
    @Test
    public void test01(){
        File f = new File("img\\test.jpg");
        System.out.println("Mime Type of " + f.getName() + " is " + new MimetypesFileTypeMap().getContentType(f));
    }

    @Test
    public void test02(){
        System.out.println(new MimetypesFileTypeMap().getContentType("img\\test.jpg"));
    }

}
