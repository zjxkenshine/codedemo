package com.kenshine.metadata.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 10:54
 * @description：
 * @modified By：
 * @version: $
 */
public class Demo02Test {
    public static void main(String[] args) {
        StandardAnnotationMetadata metadata = new StandardAnnotationMetadata(MetaDemo.class, true);

        // 演示ClassMetadata的效果
        System.out.println("==============ClassMetadata==============");
        ClassMetadata classMetadata = metadata;
        System.out.println(classMetadata.getClassName());
        System.out.println(classMetadata.getEnclosingClassName());
        System.out.println(StringUtils.arrayToCommaDelimitedString(classMetadata.getMemberClassNames()));
        System.out.println(StringUtils.arrayToCommaDelimitedString(classMetadata.getInterfaceNames()));
        System.out.println(classMetadata.hasSuperClass());
        System.out.println(classMetadata.getSuperClassName());

        System.out.println(classMetadata.isAnnotation());
        System.out.println(classMetadata.isFinal());
        System.out.println(classMetadata.isIndependent());

        // 演示AnnotatedTypeMetadata的效果
        System.out.println("==============AnnotatedTypeMetadata==============");
        AnnotatedTypeMetadata annotatedTypeMetadata = metadata;
        System.out.println(annotatedTypeMetadata.isAnnotated(Service.class.getName()));
        System.out.println(annotatedTypeMetadata.isAnnotated(Component.class.getName()));

        System.out.println(annotatedTypeMetadata.getAnnotationAttributes(Service.class.getName()));
        System.out.println(annotatedTypeMetadata.getAnnotationAttributes(Component.class.getName()));
        System.out.println(annotatedTypeMetadata.getAnnotationAttributes(EnableAsync.class.getName()));

        // 看看getAll的区别：value都是数组的形式
        System.out.println(annotatedTypeMetadata.getAllAnnotationAttributes(Service.class.getName()));
        System.out.println(annotatedTypeMetadata.getAllAnnotationAttributes(Component.class.getName()));
        System.out.println(annotatedTypeMetadata.getAllAnnotationAttributes(EnableAsync.class.getName()));

        // 演示AnnotationMetadata子接口的效果（重要）
        System.out.println("==============AnnotationMetadata==============");
        AnnotationMetadata annotationMetadata = metadata;
        System.out.println(annotationMetadata.getAnnotationTypes());
        //service的元注解 [org.springframework.stereotype.Component, org.springframework.stereotype.Indexed]
        System.out.println(annotationMetadata.getMetaAnnotationTypes(Service.class.getName()));
        //Component的元注解
        System.out.println(annotationMetadata.getMetaAnnotationTypes(Component.class.getName()));

        System.out.println(annotationMetadata.hasAnnotation(Service.class.getName()));
        System.out.println(annotationMetadata.hasAnnotation(Component.class.getName()));

        System.out.println(annotationMetadata.hasMetaAnnotation(Service.class.getName()));
        System.out.println(annotationMetadata.hasMetaAnnotation(Component.class.getName()));

        System.out.println(annotationMetadata.hasAnnotatedMethods(Autowired.class.getName()));
        annotationMetadata.getAnnotatedMethods(Autowired.class.getName()).forEach(methodMetadata -> {
            System.out.println(methodMetadata.getClass());
            System.out.println(methodMetadata.getMethodName());
            System.out.println(methodMetadata.getReturnTypeName());
        });

    }
}
