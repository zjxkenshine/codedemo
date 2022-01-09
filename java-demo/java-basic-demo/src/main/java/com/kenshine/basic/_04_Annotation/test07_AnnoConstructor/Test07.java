package com.kenshine.basic._04_Annotation.test07_AnnoConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 17:18
 * @description：
 * @modified By：
 * @version: $
 */
public class Test07 {
    @ConstructorAnno("自定义构造器注解")
    public Test07(){}

    public static void main(String[] args) throws NoSuchMethodException {
        //获取自定义构造器注解
        ConstructorAnno constructor = Test07.class.getConstructor().getAnnotation(ConstructorAnno.class);
        System.out.println(constructor.value());
    }
}
