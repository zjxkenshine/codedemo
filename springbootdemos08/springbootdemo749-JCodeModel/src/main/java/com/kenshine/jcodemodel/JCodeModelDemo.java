package com.kenshine.jcodemodel;

import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JCodeModelException;
import com.helger.jcodemodel.JPackage;
import com.helger.jcodemodel.writer.JCMWriter;

import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JCodeModelDemo
 * @Description JCodeModel使用测试
 * @Date 2024-03-15 9:17
 * @modified By：
 * @version: 1.0$
 */
public class JCodeModelDemo {

    public static void main(String[] args) throws JCodeModelException, IOException {
        //实例化JCodeModel对象
        JCodeModel jCodeModel = new JCodeModel();
        //生成package
        JPackage jPackage = jCodeModel._package("com.kenshine.jcodemodel");
        //在指定package下生成类
        jPackage._class("MyClass");
        //将生成的类代码写入文件
        //jCodeModel.build(new File("src/main/java/"));
        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("springbootdemo749-JCodeModel/src/main/java/"));
    }
}
