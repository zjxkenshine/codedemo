package com.kenshine.basic._04_Annotation.test05_AnnoMethod;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:52
 * @description：
 * @modified By：
 * @version: $
 */
public class Test05 {
    @MethodAnno("这是方法注解")
    public static void test(){}

    public static void main(String[] args) throws NoSuchMethodException {
        MethodAnno methodAnno = Test05.class.getMethod("test").getAnnotation(MethodAnno.class);
        System.out.println(methodAnno.value());
    }
}
