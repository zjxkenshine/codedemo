package com.kenshine.javassist.demo01;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/17 16:51
 * @description：
 * @modified By：
 * @version: $
 */
public class InvokePerson {

    /**
     * 2.通过读取 .class 文件的方式调用
     */
    @Test
    public void test01() throws NoSuchMethodException, NotFoundException, CannotCompileException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        // 设置类路径
        pool.appendClassPath("F:\\IDEAworkespace\\codedemo\\springboot-demos03\\springbootdemo228-Javassist\\src\\main\\java\\");
        CtClass cc = pool.get("com.kenshine.javassist.demo01.Person");

        //与反射方式相同
        Object person = cc.toClass().newInstance();
        // 设置值
        Method setName = person.getClass().getMethod("setName", String.class);
        setName.invoke(person, "qin");
        // 输出值
        Method execute = person.getClass().getMethod("printName");
        execute.invoke(person);
    }

    /**
     * 3.通过接口的方式
     * 反射开销大而且麻烦
     */
    @Test
    public void test02() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        pool.appendClassPath("F:\\IDEAworkespace\\codedemo\\springboot-demos03\\springbootdemo228-Javassist\\src\\main\\java\\");

        // 获取接口
        CtClass codeClassI = pool.get("com.kenshine.javassist.demo01.IPerson");
        // 获取上面生成的类
        CtClass ctClass = pool.get("com.kenshine.javassist.demo01.Person");
        // 使代码生成的类，实现 PersonI 接口
        ctClass.setInterfaces(new CtClass[]{codeClassI});

        // 以下通过接口直接调用 强转
        IPerson person = (IPerson)ctClass.toClass().newInstance();
        System.out.println(person.getName());
        person.setName("qin");
        person.printName();
    }


}
