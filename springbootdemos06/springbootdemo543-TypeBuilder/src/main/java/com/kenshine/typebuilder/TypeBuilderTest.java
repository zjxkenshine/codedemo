package com.kenshine.typebuilder;

import ikidou.reflect.TypeBuilder;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname TypeBuilderTest
 * @Description  TypeBuilder 泛型测试
 * @Date 2023-12-06 8:17
 * @modified By：
 * @version: 1.0$
 */
public class TypeBuilderTest {

    /**
     *  获取List<String>泛型
     */
    @Test
    public void test01(){
        Type type = TypeBuilder
                .newInstance(List.class)
                .addTypeParam(String.class)
                .build();
        System.out.println(type.getTypeName());
    }

    /**
     * List<? super String>
     */
    @Test
    public void test02() throws IllegalAccessException, InstantiationException {
        Type type = TypeBuilder
                .newInstance(List.class)
                .addTypeParamSuper(String.class)
                .build();
        System.out.println(type.getTypeName());
    }

    /**
     * List<? extends CharSequence>
     */
    @Test
    public void test03(){
        Type type = TypeBuilder
                .newInstance(List.class)
                .addTypeParamExtends(CharSequence.class)
                .build();
        System.out.println(type.getTypeName());
    }

    /**
     * Map<String, String[]>
     */
    @Test
    public void test04(){
        Type type = TypeBuilder
                .newInstance(HashMap.class)
                .addTypeParam(String.class)
                .addTypeParam(String[].class)
                .build();
        System.out.println(type.getTypeName());
    }

    /**
     * Map<String, List<String>>
     */
    @Test
    public void test05(){
        Type type = TypeBuilder
                .newInstance(Map.class)
                .addTypeParam(String.class)
                //开始 List<String> 部分
                .beginSubType(List.class)
                //设置List的泛型值
                .addTypeParam(String.class)
                .endSubType() //结束 List<String> 部分
                .build();
        System.out.println(type.getTypeName());
    }

    /**
     * java反射获取泛型定义类型
     */
    @Test
    public void test06(){
        List<String> list=new ArrayList<>();

        //返回本类的父类包含泛型信息
        Type superclass = list.getClass().getGenericSuperclass();

        //获取泛型参数 E
        for (Type t : ((ParameterizedType) superclass).getActualTypeArguments()) {
            System.out.println(t);
        }
    }

    /**
     * java反射 获取泛型运行时的具体类型
     */
    @Test
    public void test07(){
        // 不创建匿名包装类
        System.out.println(getGenericRuntimeType(new ArrayList<String>()));
        // 通过反射获取泛型的具体类型 创建匿名子类
        System.out.println(getGenericRuntimeType(new ArrayList<String>(){}));
    }


    public static <T> Type getGenericRuntimeType(ArrayList<T> list) {
        Type type = list.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType)type).getActualTypeArguments();
            return types[0];
        }
        return null;
    }

}
