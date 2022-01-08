package com.kenshine.basic._01_base;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 22:31
 * @description：String常量池
 * @modified By：
 * @version: $
 */
public class test03_String {
    public static void main(String[] args) {
        String str1="abc";
        String str2="abc";
        //new的String对象都不在常量池中
        String str3=new String(new char[]{'a','b','c'});
        System.out.println(str1==str2); //true
        System.out.println(str2==str3); //false
        System.out.println(str1==str3); //false
    }
}
