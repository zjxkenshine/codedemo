package com.kenshine.javapoet;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 9:44
 * @description：helloworld
 * @modified By：
 * @version: $
 */
public class Test01Hello {
    public static void main(String[] args) throws IOException {
        //申明一个方法对象，方法名是“main”
        MethodSpec main = MethodSpec.methodBuilder("main")
                //方法添加描述符，公开且静态的方法
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                //方法添加返回类型，为void空返回
                .returns(void.class)
                //方法添加参数类型是string[],名称是args
                .addParameter(String[].class, "args")
                //方法添加内容，一句打印 System.out.println("HelloJavaPoet!")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        //申明一个类对象，类名是“HelloJavaPoet”
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloJavaPoet")
                //类添加描述符，公开且不可继承的类
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                //类添加方法，前面定义的 MethodSpec 变量  main
                .addMethod(main)
                .build();
        //申明一个java文件输出对象
        JavaFile javaFile = JavaFile.builder("com.kenshine.javapoet;", helloWorld)
                .build();
        //输出文件
        javaFile.writeTo(System.out);
    }
}
