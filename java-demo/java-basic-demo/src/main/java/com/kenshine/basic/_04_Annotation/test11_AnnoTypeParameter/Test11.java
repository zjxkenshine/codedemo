package com.kenshine.basic._04_Annotation.test11_AnnoTypeParameter;

import sun.reflect.annotation.TypeAnnotation;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 19:10
 * @description： 泛型类型参数注解
 * @modified By：
 * @version: $
 */
public class Test11 {
    public static void main(String[] args) throws NoSuchMethodException {
        //TypeVariable 类型参数
        TypeVariable<Class<Generic>>[] types= Generic.class.getTypeParameters();
        for (TypeVariable<Class<Generic>> type: types){
            //泛型类型参数方法
            System.out.println(type.getAnnotation(TypeParamAnno.class).value());
            System.out.println(type.getName());
        }

        //泛型方法的类型参数
        TypeVariable<Method>[] typeParameters=Generic.class.getMethod("test", Object.class).getTypeParameters();
        for (TypeVariable<Method> type1: typeParameters){
            System.out.println(type1.getAnnotation(TypeParamAnno.class).value());
            System.out.println(type1);
        }
    }
}
