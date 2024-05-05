package com.kenshine.reflectionkit;

import idea.verlif.reflection.domain.ClassGrc;
import idea.verlif.reflection.domain.MethodGrc;
import idea.verlif.reflection.util.FieldUtil;
import idea.verlif.reflection.util.MethodUtil;
import idea.verlif.reflection.util.ReflectUtil;
import idea.verlif.reflection.util.SignatureUtil;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname ReflectionTest
 * @Description 反射工具类使用测试
 * @Date 2024-05-05 10:41
 * @modified By：
 * @version: 1.0$
 */
public class ReflectionTest {
    /**
     * FieldUtil 属性工具
     */
    @Test
    public void test01() throws NoSuchFieldException {
        TestBean bean=new TestBean();
        bean.setA("kenshine");
        bean.setB(11);
        // 获取类的所有属性
        List<Field> fields= FieldUtil.getAllFields(TestBean.class);
        fields.forEach(field -> System.out.println(field.getName()));
        // 从对象获取属性值
        String a=(String)FieldUtil.getFieldValue(bean,"a");
        System.out.println(a);
        // 设置对象的属性值
        FieldUtil.setFieldValue(bean,"b",19);
        System.out.println(bean.getB());
    }

    /**
     * MethodUtil 方法工具类
     */
    @Test
    public void test02() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException {
        // 所有方法
        List<Method> methods=MethodUtil.getAllMethods(TestBean.class);
        methods.forEach(method -> System.out.println(method.getName()));
        // 获取指定方法
        Method m=MethodUtil.getMethod(TestBean.class,"setA",String.class);
        // 获取方法泛型信息
        MethodGrc grc=MethodUtil.getMethodGrc(m);
        System.out.println(grc);

        TestBean bean=new TestBean();
        // 调用方法
        MethodUtil.invoke(bean,"setA","kenshine");
        System.out.println(bean);
    }

    /**
     * 获取类信息
     */
    @Test
    public void test03() throws NoSuchFieldException, IllegalAccessException {
        // 获取类的泛型标记表
        Map<String, ClassGrc> classGrcMap= ReflectUtil.getGenericsMap(HashMap.class);
        classGrcMap.forEach((k,v)-> System.out.println(k+" : "+v));
    }

    /**
     * 签名工具表
     */
    @Test
    public void test04() throws IllegalAccessException {
        String sign=SignatureUtil.getSignature(TestBean.class);
        System.out.println(sign);
    }
}
