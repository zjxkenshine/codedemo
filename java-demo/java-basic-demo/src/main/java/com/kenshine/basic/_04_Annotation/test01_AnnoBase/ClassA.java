package com.kenshine.basic._04_Annotation.test01_AnnoBase;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:13
 * @description：
 * @modified By：
 * @version: $
 * 自定义注解的使用
 */
@MyAnno(
        value = 1,
        per = Person.A,
        anno2 = @MyAnno2("test"),
        strs = {"a","b"}
)
public class ClassA {

    public static void main(String[] args) {
        //获取自定义嵌套注解中的值
        System.out.println(ClassA.class.getAnnotation(MyAnno.class).anno2().value());
    }
}
