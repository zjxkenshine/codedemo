package com.kenshine.basic._02_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 12:54
 * @description：泛型数组
 * @modified By：
 * @version: $
 */
public class test14_GenericArray {

    public static void main(String[] args) {
        //不能创建泛型数组
        //List<String>[] ls = new ArrayList<String>[10];
        List<?>[] ls1 = new ArrayList<?>[10];       //？ 可以
        List<String>[] ls2 = new ArrayList[10];     //这样也可以
    }
}
