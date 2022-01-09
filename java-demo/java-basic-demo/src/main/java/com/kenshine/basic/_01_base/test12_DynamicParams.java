package com.kenshine.basic._01_base;

import java.util.ArrayList;
import java.util.Arrays;

import static com.sun.deploy.uitoolkit.impl.awt.AWTClientPrintHelper.print;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 23:52
 * @description：
 * @modified By：
 * @version: $
 *
 * 1.一个方法的参数列表只能有一个可变参数
 * 2.如果方法参数有多个，可变参数必须写在参数列表的末尾
 */
public class test12_DynamicParams {
    public static void main(String[] args) {
        printInt(1,2,3,5,6,8,7);
    }

    public static void printInt(int... params){
        for(int i:params){
            System.out.println(i);
        }
    }
}
