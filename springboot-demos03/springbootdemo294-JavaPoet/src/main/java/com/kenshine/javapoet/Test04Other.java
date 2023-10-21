package com.kenshine.javapoet;

import com.squareup.javapoet.*;
import org.junit.Test;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.LogRecord;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 10:32
 * @description：方法、内部类、接口、枚举、注释等
 * @modified By：
 * @version: $
 */
public class Test04Other {
    /**
     * Modifiers.ABSTRACT 可获得接口和抽象类
     */
    @Test
    public void test01() throws IOException {
        MethodSpec flux = MethodSpec.methodBuilder("flux")
                .addModifiers(Modifier.ABSTRACT, Modifier.PROTECTED)
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addMethod(flux)
                .build();

        //申明一个java文件输出对象
        JavaFile javaFile = JavaFile.builder("com.kenshine.javapoet;", helloWorld)
                .build();
        javaFile.writeTo(System.out);
    }

    /**
     * 构造方法
     */
    @Test
    public void test02() throws IOException {
        MethodSpec flux = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(String.class, "greeting")
                .addStatement("this.$N = $N", "greeting", "greeting")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC)
                .addField(String.class, "greeting", Modifier.PRIVATE, Modifier.FINAL)
                .addMethod(flux)
                .build();

        //申明一个java文件输出对象
        JavaFile javaFile = JavaFile.builder("com.kenshine.javapoet;", helloWorld)
                .build();
        javaFile.writeTo(System.out);
    }

    /**
     * 参数
     * 定义方法的参数可以使用ParameterSpec或者使用MethodSpect的addParameterAPI来实现
     */
    @Test
    public void test03(){
        ParameterSpec android = ParameterSpec.builder(String.class, "android")
                .addModifiers(Modifier.FINAL)
                .build();

        MethodSpec welcomeOverlords = MethodSpec.methodBuilder("welcomeOverlords")
                .addParameter(android)
                .addParameter(String.class, "robot", Modifier.FINAL)
                .build();

        System.out.println(welcomeOverlords.toString());
    }

    /**
     * 接口 定义
     */
    @Test
    public void test04(){
        TypeSpec helloWorld = TypeSpec.interfaceBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC)
                .addField(FieldSpec.builder(String.class, "ONLY_THING_THAT_IS_CONSTANT")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                        .initializer("$S", "change")
                        .build())
                .addMethod(MethodSpec.methodBuilder("beep")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .build())
                .build();
        System.out.println(helloWorld.toString());
    }

    /**
     * 枚举
     */
    @Test
    public void test05(){
        TypeSpec helloWorld = TypeSpec.enumBuilder("Roshambo")
                .addModifiers(Modifier.PUBLIC)
                .addEnumConstant("ROCK")
                .addEnumConstant("SCISSORS")
                .addEnumConstant("PAPER")
                .build();
        System.out.println(helloWorld.toString());
    }

    /**
     * 匿名内部类
     */
    @Test
    public void test06(){
        TypeSpec comparator = TypeSpec.anonymousClassBuilder("")
                .addSuperinterface(ParameterizedTypeName.get(Comparator.class, String.class))
                .addMethod(MethodSpec.methodBuilder("compare")
                        .addAnnotation(Override.class)
                        .addModifiers(Modifier.PUBLIC)
                        .addParameter(String.class, "a")
                        .addParameter(String.class, "b")
                        .returns(int.class)
                        .addStatement("return $N.length() - $N.length()", "a", "b")
                        .build())
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addMethod(MethodSpec.methodBuilder("sortByLength")
                        .addParameter(ParameterizedTypeName.get(List.class, String.class), "strings")
                        .addStatement("$T.sort($N, $L)", Collections.class, "strings", comparator)
                        .build())
                .build();
        System.out.println(helloWorld.toString());
    }

    /**
     * 注解
     */
    @Test
    public void test07(){
        MethodSpec toString = MethodSpec.methodBuilder("toString")
                .addAnnotation(Override.class)
                .returns(String.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return $S", "Hoverboard")
                .build();
        System.out.println(toString.toString());
    }

    /**
     * 注解属性
     */
    @Test
    public void test08(){
        MethodSpec logRecord = MethodSpec.methodBuilder("recordEvent")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addAnnotation(AnnotationSpec.builder(Headers.class)
                        .addMember("accept", "$S", "application/json; charset=utf-8")
                        .addMember("userAgent", "$S", "Square Cash")
                        .build())
                .addParameter(LogRecord.class, "logRecord")
                .returns(String.class)
                .build();
        System.out.println(logRecord);
    }

}
