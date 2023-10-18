package com.kenshine.classmate;

import com.fasterxml.classmate.*;
import com.fasterxml.classmate.members.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description 官方示例
 * @Date 2023-10-18 10:34
 * @modified By：
 * @version: 1.0$
 */
public class Test02 {

    @Test
    public void test01(){
        TypeResolver typeResolver = new TypeResolver();
        // listType => List<Object>
        ResolvedType listType = typeResolver.resolve(List.class);
        System.out.println(listType);

        // listType => List<String>
        ResolvedType listType1 = typeResolver.resolve(List.class, String.class);
        System.out.println(listType1);


        ResolvedType stringType2 = typeResolver.resolve(String.class);
        // listType => List<String>
        ResolvedType listType2 = typeResolver.resolve(List.class, stringType2);
        System.out.println(listType2);

        // listType => List<String>
        ResolvedType listType3 = typeResolver.resolve(new GenericType<List<String>>() {});
        System.out.println(listType3);
    }


    /**
     * 方法解析 ArrayList<String>为例
     */
    @Test
    public void test02(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType arrayListType = typeResolver.resolve(ArrayList.class, String.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        ResolvedTypeWithMembers arrayListTypeWithMembers = memberResolver.resolve(arrayListType, null, null);
        // 静态方法
        ResolvedMethod[] staticArrayListMethods = arrayListTypeWithMembers.getStaticMethods();
        //获取实例方法
        ResolvedMethod[] arrayListMethods = arrayListTypeWithMembers.getMemberMethods();

        System.out.println(Arrays.stream(staticArrayListMethods).collect(Collectors.toList()));
        System.out.println(Arrays.stream(arrayListMethods).collect(Collectors.toList()));
    }

    /**
     * 属性解析 ArrayList<String>为例
     */
    @Test
    public void test03(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType arrayListType = typeResolver.resolve(ArrayList.class, String.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        ResolvedTypeWithMembers arrayListTypeWithMembers = memberResolver.resolve(arrayListType, null, null);
        // 静态、实例属性
        ResolvedField[] arrayListFields = arrayListTypeWithMembers.getMemberFields();
        System.out.println(Arrays.stream(arrayListFields).collect(Collectors.toList()));
    }

    /**
     * 构造器解析 ArrayList<String>为例
     */
    @Test
    public void test04(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType arrayListType = typeResolver.resolve(ArrayList.class, String.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        ResolvedTypeWithMembers arrayListTypeWithMembers = memberResolver.resolve(arrayListType, null, null);
            // get static/instance fields
        ResolvedConstructor[] arrayListConstructors = arrayListTypeWithMembers.getConstructors();
        System.out.println(Arrays.stream(arrayListConstructors).collect(Collectors.toList()));
    }


    /**
     * 解析Size方法
     */
    @Test
    public void test05(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType arrayListType = typeResolver.resolve(ArrayList.class, String.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        memberResolver.setMethodFilter(new Filter<RawMethod>() {
            @Override public boolean include(RawMethod element) {
                return "size".equals(element.getName());
            }
        });
        ResolvedTypeWithMembers arrayListTypeWithMembers = memberResolver.resolve(arrayListType, null, null);
        ResolvedMethod sizeMethod = arrayListTypeWithMembers.getMemberMethods()[0];
        System.out.println(sizeMethod);
    }

    /**
     * 解析size属性
     */
    @Test
    public void test06(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType arrayListType = typeResolver.resolve(ArrayList.class, String.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        memberResolver.setFieldFilter(new Filter<RawField>() {
            @Override public boolean include(RawField element) {
                return "size".equals(element.getName());
            }
        });
        ResolvedTypeWithMembers arrayListTypeWithMembers = memberResolver.resolve(arrayListType, null, null);
        ResolvedField sizeField = arrayListTypeWithMembers.getMemberFields()[0];
        System.out.println(sizeField);
    }



}
