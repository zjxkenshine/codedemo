package com.kenshine.metadata.demo01;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 10:23
 * @description：
 * @modified By：
 * @version: $
 */
public class MetadataReaderTest {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        MetadataReader metadataReader = new CachingMetadataReaderFactory().getMetadataReader(TestA.class.getName());
        Resource resource = metadataReader.getResource();
        System.out.println(resource.getURL());
        System.out.println(resource.getURI());
        System.out.println(resource.getDescription());

        //获取ClassMetadata
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //所有无参方法测试
        Method[] methods = ClassMetadata.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ":" + method.invoke(classMetadata));
        }

        System.out.println("============================================================================");
        MetadataReader metadataReader1 = new SimpleMetadataReaderFactory().getMetadataReader(TestA.class.getName());

        //获取AnnotationMetadata
        AnnotationMetadata annotationMetadata = metadataReader1.getAnnotationMetadata();
        System.out.println(annotationMetadata.getAnnotationTypes());
        System.out.println(annotationMetadata.getMetaAnnotationTypes(Component.class.getName()));
        System.out.println(annotationMetadata.getMetaAnnotationTypes(TestReader.class.getName()));
        System.out.println(annotationMetadata.getAllAnnotationAttributes(TestReader.class.getName()));
    }
}
