package com.kenshine.javapoet;

import com.squareup.javapoet.*;
import org.junit.Test;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 10:05
 * @description：匹配占位符
 * @modified By：
 * @version: $
 */
public class Test03Match {

    /**
     * $L 通用占位符
     */
    @Test
    public void test01(){
        MethodSpec main = MethodSpec.methodBuilder("main")
                .returns(int.class)
                .addStatement("int result = 0")
                .beginControlFlow("for (int i = $L; i < $L; i++)", 0, 10)
                .addStatement("result = result $L i", "*")
                .endControlFlow()
                .addStatement("return result")
                .build();
        System.out.println(main.toString());
    }

    /**
     * $S (string占位符)
     */
    @Test
    public void test02() throws IOException {
        MethodSpec sayHelloMethodSpec = MethodSpec.methodBuilder("sayHello")
                .returns(String.class)
                .addStatement("return $S", "Hello boy!")
                .build();


        TypeSpec helloWorld = TypeSpec.classBuilder("SayHello")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(sayHelloMethodSpec)
                .build();

        JavaFile javaFile = JavaFile.builder("com.kenshine.javapoet", helloWorld)
                .build();

        javaFile.writeTo(System.out);
    }

    /**
     * $T (类型占位符)
     */
    @Test
    public void test03() throws IOException {
        MethodSpec today = MethodSpec.methodBuilder("today")
                .returns(Date.class)
                .addStatement("return new $T()", Date.class)
                .build();

        TypeSpec date = TypeSpec.classBuilder("Date")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(today)
                .build();

        JavaFile javaFile = JavaFile.builder("com.kenshine.javapoet", date)
                .build();

        javaFile.writeTo(System.out);
    }

    /**
     *  $T 替换ClassName
     */
    @Test
    public void test04(){
        ClassName hoverboard = ClassName.get("com.mattel", "Hoverboard");
        ClassName list = ClassName.get("java.util", "List");
        ClassName arrayList = ClassName.get("java.util", "ArrayList");
        TypeName listOfHoverboards = ParameterizedTypeName.get(list, hoverboard);

        MethodSpec beyond = MethodSpec.methodBuilder("beyond")
                .returns(listOfHoverboards)
                .addStatement("$T result = new $T<>()", listOfHoverboards, arrayList)
                .addStatement("result.add(new $T())", hoverboard)
                .addStatement("result.add(new $T())", hoverboard)
                .addStatement("result.add(new $T())", hoverboard)
                .addStatement("return result")
                .build();
        System.out.println(beyond.toString());
    }

    /**
     * 静态导入
     */
    @Test
    public void test05() throws IOException {
        ClassName hoverboard = ClassName.get("com.mattel", "Hoverboard");
        ClassName list = ClassName.get("java.util", "List");
        ClassName arrayList = ClassName.get("java.util", "ArrayList");
        TypeName listOfHoverboards = ParameterizedTypeName.get(list, hoverboard);
        ClassName namedBoards = ClassName.get("com.mattel", "Hoverboard", "Boards");

        MethodSpec beyond = MethodSpec.methodBuilder("beyond")
                .returns(listOfHoverboards)
                .addStatement("$T result = new $T<>()", listOfHoverboards, arrayList)
                .addStatement("result.add($T.createNimbus(2000))", hoverboard)
                .addStatement("result.add($T.createNimbus(\"2001\"))", hoverboard)
                .addStatement("result.add($T.createNimbus($T.THUNDERBOLT))", hoverboard, namedBoards)
                .addStatement("$T.sort(result)", Collections.class)
                .addStatement("return result.isEmpty() ? $T.emptyList() : result", Collections.class)
                .build();

        TypeSpec hello = TypeSpec.classBuilder("HelloWorld")
                .addMethod(beyond)
                .build();

        JavaFile javaFile=JavaFile.builder("com.example.helloworld", hello)
                .addStaticImport(hoverboard, "createNimbus")
                .addStaticImport(namedBoards, "*")
                .addStaticImport(Collections.class, "*")
                .build();
        javaFile.writeTo(System.out);
    }

    /**
     * $N 占位符代指的是一个名称，方法名称，变量名称等
     */
    @Test
    public void test06(){
        MethodSpec beyond = MethodSpec.methodBuilder("beyond")
                .addStatement("data.$N()","toString").build();
        System.out.println(beyond.toString());
    }

    /**
     * 相对参数
     */
    @Test
    public void test07(){
        String s=CodeBlock.builder().add("I ate $L $L", 3, "tacos").build().toString();
        System.out.println(s);
    }

    /**
     * 位置参数
     */
    @Test
    public void test08(){
        String s=CodeBlock.builder().add("I ate $2L $1L", "tacos", 3).build().toString();
        System.out.println(s);
    }

    /**
     * 命名参数
     */
    @Test
    public void test09(){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("food", "tacos");
        map.put("count", 3);
        String s=CodeBlock.builder().addNamed("I ate $count:L $food:L", map).build().toString();
        System.out.println(s);
    }
}
