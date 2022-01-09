package com.kenshine.basic._02_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 9:53
 * @description：
 * @modified By：
 * @version: $
 */
public class test01 {
    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println(classStringArrayList);
            System.out.println(classIntegerArrayList);
            System.out.println("类型相同");
        }
    }
}
