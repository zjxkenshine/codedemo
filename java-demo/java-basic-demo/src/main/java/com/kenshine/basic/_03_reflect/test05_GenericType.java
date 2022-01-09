package com.kenshine.basic._03_reflect;

import java.lang.reflect.Array;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 14:19
 * @description：泛型数组操作
 * @modified By：
 * @version: $
 */
public class test05_GenericType {

    //Arrays.CopyOf方法实现示例
    public static Object CopyOf(Object a,int newLength){
        Class cl=a.getClass();
        //判断是否为数组
        if(!cl.isArray()) return null;
        //确定数组的正确类型，是Class类的方法
        Class componentType=cl.getComponentType();
        //获取原长度
        int length= Array.getLength(a);
        //构造一个新数组，参数(元素类型，长度)
        Object newArray=Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }

}


