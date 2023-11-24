package com.kenshine.soot.test03;

import soot.*;
import soot.tagkit.GenericAttribute;

import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname Test03_Instruction
 * @Description 分析指令
 * @Date 2023-11-24 12:31
 * @modified By：
 * @version: 1.0$
 */
public class Test03_Instruction {

    public static void main(String[] args) {
        SootClass sClass;
        SootMethod method;

        // Resolve dependencies
        Scene.v().loadClassAndSupport("java.lang.Object");
        Scene.v().loadClassAndSupport("java.lang.System");

        // Declare 'public class HelloWorld'
        sClass = new SootClass("HelloWorld", Modifier.PUBLIC);

        // 'extends Object'
        sClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
        Scene.v().addClass(sClass);

        // Create the method, public static void main(String[])
        method = new SootMethod("main",
                Arrays.asList(new Type[] {ArrayType.v(RefType.v("java.lang.String"), 1)}),
                VoidType.v(), Modifier.PUBLIC | Modifier.STATIC);

        sClass.addMethod(method);

        // 添加属性
        GenericAttribute classAttr = new GenericAttribute(
                "ca.mcgill.sable.MyClassAttr",
                "foo".getBytes());
        sClass.addTag(classAttr);

        // 判断是否有man方法
        if (!Scene.v().getMainClass().
                declaresMethod("void main(java.lang.String[])")) {
            throw new RuntimeException("couldn't find main() in mainClass");
        }

        // 添加gotoCount field
        SootField gotoCounter = new SootField("gotoCount", LongType.v(),
                Modifier.STATIC);
        Scene.v().getMainClass().addField(gotoCounter);
        // 获取field
        SootField gotoCounter1 = Scene.v().getMainClass().getFieldByName("gotoCount");

    }
}
