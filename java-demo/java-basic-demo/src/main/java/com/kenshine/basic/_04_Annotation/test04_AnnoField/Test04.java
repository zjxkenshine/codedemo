package com.kenshine.basic._04_Annotation.test04_AnnoField;

import java.lang.reflect.Field;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:45
 * @description：
 * @modified By：
 * @version: $
 */
public class Test04 {
    @FieldAnno("这是别名")
    public static final String name="这是原名";

    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> clazz= Test04.class;
        //获取字段
        Field field= clazz.getField("name");
        //注解
        FieldAnno fieldAnno = field.getAnnotation(FieldAnno.class);
        System.out.println(fieldAnno.value());

    }
}
