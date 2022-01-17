package com.kenshine.javassist.demo01;

import javassist.*;

import java.lang.reflect.Method;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/17 15:48
 * @description：
 * @modified By：
 * @version: $
 */
public class CreatePerson {
    /**
     * 创建一个Person 对象
     *
     * @throws Exception
     */
    public static void createPerson() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // 1. 创建一个空类
        CtClass cc = pool.makeClass("com.kenshine.javassist.demo01.Person");

        // 2. 新增一个字段 private String name;
        // 字段名为name
        CtField param = new CtField(pool.get("java.lang.String"), "name", cc);
        // 访问级别是 private
        param.setModifiers(Modifier.PRIVATE);
        // 初始值是 "kenshine"
        cc.addField(param, CtField.Initializer.constant("kenshine"));

        // 3. 生成 getter、setter 方法
        cc.addMethod(CtNewMethod.setter("setName", param));
        cc.addMethod(CtNewMethod.getter("getName", param));

        // 4. 添加无参的构造函数
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);
        cons.setBody("{name = \"kenshine\";}");
        cc.addConstructor(cons);

        // 5. 添加有参的构造函数
        cons = new CtConstructor(new CtClass[]{pool.get("java.lang.String")}, cc);
        // $0=this / $1,$2,$3... 代表方法参数
        cons.setBody("{$0.name = $1;}");
        cc.addConstructor(cons);

        // 6. 创建一个名为printName方法，无参数，无返回值，输出name值
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printName", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(name);}");
        cc.addMethod(ctMethod);

        //这里会将这个创建的类对象编译为.class文件
        //cc.writeFile("F:\\IDEAworkespace\\codedemo\\springboot-demos03\\springbootdemo228-Javassist\\src\\main\\java");


        //1. 通过反射的方式调用
        // 这里不写入文件，直接实例化
        Object person = cc.toClass().newInstance();
        // 设置值
        Method setName = person.getClass().getMethod("setName", String.class);
        setName.invoke(person, "qin");
        // 输出值
        Method execute = person.getClass().getMethod("printName");
        execute.invoke(person);

    }

    public static void main(String[] args) {
        try {
            createPerson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
