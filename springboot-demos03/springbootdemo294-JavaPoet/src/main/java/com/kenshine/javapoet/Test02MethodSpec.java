package com.kenshine.javapoet;

import com.squareup.javapoet.MethodSpec;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 9:50
 * @description：模型
 * @modified By：
 * @version: $
 * 类和接口模型（TypeSpec），
 * 字段模型 (FieldSpec)、
 * 方法和构造函数模型 (MethodSpec)、
 * 参数模型 (ParameterSpec)
 * 注释模型（AnnotationSpec）
 */
public class Test02MethodSpec {

    /**
     *  MethodSpec
     */
    @Test
    public void test01(){
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addCode(""
                        + "int total = 0;\n"
                        + "for (int i = 0; i < 10; i++) {\n"
                        + "if(i/2=0){\n"
                        + "  total += i;\n"
                        + "  }\n"
                + " return total;\n"
        + "}\n").build();

        System.out.println(main.toString());
    }

    /**
     * MethodSpec
     * 分号和换行的操作 beginControlFlow() + endControlFlow()
     */
    @Test
    public void test02(){
        MethodSpec main = MethodSpec.methodBuilder("main")
                .returns(int.class)
                .addStatement("int total = 0")
                .beginControlFlow("for (int i = 0; i < 10; i++)")
                .beginControlFlow("if(i/2=0)")
                .addStatement("total += i")
                .endControlFlow()
                .endControlFlow()
                .addStatement("return total")
                .build();
        System.out.println(main.toString());
    }

    /**
     * if/else try/catch这种控制流的语句 nextControlFlow()
     */
    @Test
    public void test03(){
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addStatement("long now = $T.currentTimeMillis()", System.class)
                .beginControlFlow("if ($T.currentTimeMillis() < now)", System.class)
                .addStatement("$T.out.println($S)", System.class, "Time travelling, woo hoo!")
                .nextControlFlow("else if ($T.currentTimeMillis() == now)", System.class)
                .addStatement("$T.out.println($S)", System.class, "Time stood still!")
                .endControlFlow()
                .beginControlFlow("try")
                .addStatement("throw new Exception($S)", "出错啦")
                .nextControlFlow("catch ($T e)", Exception.class)
                .addStatement("throw new $T(e)", RuntimeException.class)
                .endControlFlow()
                .build();
        System.out.println(main.toString());
    }
}
