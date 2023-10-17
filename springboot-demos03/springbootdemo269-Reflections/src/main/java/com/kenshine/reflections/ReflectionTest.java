package com.kenshine.reflections;

import com.kenshine.reflections.test02.SomeAnnotation;
import com.kenshine.reflections.test02.SomeType;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author by kenshine
 * @Classname ReflectionTest
 * @Description 测试
 * @Date 2023-10-17 14:59
 * @modified By：
 * @version: 1.0$
 */
public class ReflectionTest {

    /**
     *  获取自定义注解修饰的类、方法、属性
     */
    @Test
    public void test01(){
        // 默认支持Scanners.TypesAnnotated, Scanners.SubTypes 两种扫描类型
        Reflections reflections = new Reflections("com.kenshine.reflections",
                Scanners.SubTypes,
                Scanners.FieldsAnnotated,
                Scanners.TypesAnnotated,
                Scanners.MethodsAnnotated);
        // Reflections reflections = new Reflections("com.kenshine.reflections");
        // 获取有MyAnnotation注解修饰的类
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MyAnnotation.class);
        // 获取有MyAnnotation注解修饰的属性
        Set<Field> fields = reflections.getFieldsAnnotatedWith(MyAnnotation.class);
        // 获取有MyAnnotation注解修饰的方法
        Set<Method> methods = reflections.getMethodsAnnotatedWith(MyAnnotation.class);
        System.out.println(classes);
        System.out.println(fields);
        System.out.println(methods);
    }

    @Test
    public void test02(){
        // 实例化Reflections，并指定要扫描的包名
        Reflections reflections1 = new Reflections("com.kenshine.reflections.test02",
                Scanners.values());
        // 获取某个类的所有子类
        Set<Class<? extends SomeType>> subTypes = reflections1.getSubTypesOf(SomeType.class);
        // 获取包含某个注解的所有类
        Set<Class<?>> annotated = reflections1.getTypesAnnotatedWith(SomeAnnotation.class);

        //ResourcesScanner 扫描资源 扫描不到
        Set<String> properties = reflections1.getResources(Pattern.compile(".*\\.properties"));

        //MethodAnnotationsScanner 扫描方法（构造方法）注解
        Set<Method> resources = reflections1.getMethodsAnnotatedWith(SomeAnnotation.class);
        Set<Constructor> injectables = reflections1.getConstructorsAnnotatedWith(SomeAnnotation.class);

        //FieldAnnotationsScanner 扫描字段注解
        Set<Field> ids = reflections1.getFieldsAnnotatedWith(SomeAnnotation.class);

        //MethodParameterScanner 扫描方法参数
        Set<Method> someMethods =reflections1.getMethodsWithSignature(int.class);
        Set<Method> voidMethods = reflections1.getMethodsReturn(void.class);
        // 含有参数注解的方法
        Set<Method> pathParamMethods =reflections1.getMethodsAnnotatedWith(SomeAnnotation.class);


        System.out.println(subTypes);
        System.out.println(annotated);
        System.out.println(properties);
        System.out.println(resources);
        System.out.println(injectables);
        System.out.println(ids);
        System.out.println(someMethods);
        System.out.println(voidMethods);
        System.out.println(pathParamMethods);
    }
}
