package com.kenshine.basic._02_generic;

import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 10:47
 * @description：可变参数
 * @modified By：
 * @version: $
 */
public class test07_GenericDynamicParamMethod {
    //可变参数泛型方法
    public <T> void printMsg( T... args){
        for(T t : args){
            System.out.println(t);
        }
    }

    @Test
    public void test01(){
        printMsg("1","33","-v");
    }
}

