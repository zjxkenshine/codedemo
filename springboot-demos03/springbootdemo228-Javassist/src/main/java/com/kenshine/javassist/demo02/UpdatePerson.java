package com.kenshine.javassist.demo02;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/17 17:03
 * @description：
 * @modified By：
 * @version: $
 */
public class UpdatePerson {
    public static void update() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.kenshine.javassist.demo02.PersonService");

        //获取personFly方法
        CtMethod personFly = cc.getDeclaredMethod("personFly");
        //在方法最前面输出
        personFly.insertBefore("System.out.println(\"起飞之前准备降落伞\");");
        //在方法返回前输出
        personFly.insertAfter("System.out.println(\"成功落地。。。。\");");


        //新增一个方法
        //1.返回类型 2.方法名 3.参数类型列表 4.定义的类
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "joinFriend", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(\"i want to be your friend\");}");
        cc.addMethod(ctMethod);

        Object person = cc.toClass().newInstance();
        // 调用 personFly 方法
        Method personFlyMethod = person.getClass().getMethod("personFly");
        personFlyMethod.invoke(person);
        //调用 joinFriend 方法
        Method execute = person.getClass().getMethod("joinFriend");
        execute.invoke(person);
    }

    public static void main(String[] args) {
        try {
            update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
