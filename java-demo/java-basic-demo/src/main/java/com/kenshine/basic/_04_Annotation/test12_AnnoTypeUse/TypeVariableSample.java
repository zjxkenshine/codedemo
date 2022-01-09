package com.kenshine.basic._04_Annotation.test12_AnnoTypeUse;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 19:35
 * @description：
 * @modified By：
 * @version: $
 */
public class TypeVariableSample<T extends @UseAnno("这是泛型边界注解Serializable") Serializable & @UseAnno("这是泛型边界注解comparable") Comparable<T>> {

    public static void main(String[] args) {
        TypeVariable<Class<TypeVariableSample>>[] typeParameters = TypeVariableSample.class.getTypeParameters();

        for (int i = 0; i < typeParameters.length; i++) {
            TypeVariable<Class<TypeVariableSample>> typeVariable = typeParameters[i];
            System.out.println(typeVariable.getName());
            System.out.println(typeVariable.getGenericDeclaration());

            //Type 高层反射接口
            Type[] bounds = typeVariable.getBounds();
            for (int j = 0; j < bounds.length; j++) {
                Type bound = bounds[j];
                System.out.println("泛型边界:"+bound.getTypeName());
            }

            //AnnotatedType表示当前在此VM中运行的程序中可能注释使用的类型
            //getAnnotatedBounds 获取边界注解
            AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();
            for (int j = 0; j < annotatedBounds.length; j++) {
                StringBuilder sb = new StringBuilder();
                AnnotatedType annotatedType = annotatedBounds[j];
                System.out.println("AnnotatedType:" + annotatedType.getType());
                Annotation[] annotations = annotatedType.getDeclaredAnnotations();
                for (int k = 0; k < annotations.length; k++) {
                    Annotation annotation = annotations[k];
                    sb.append(annotation);
                }
                sb.append(" " + annotatedType.getType().getTypeName());
                System.out.println(sb.toString());
            }
        }
    }
}
