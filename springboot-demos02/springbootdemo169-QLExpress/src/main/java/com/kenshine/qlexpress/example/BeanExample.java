package com.kenshine.qlexpress.example;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/11 9:10
 * @description：绑定对象方法
 * @modified By：
 * @version: $
 */
public class BeanExample {

    public static String upper(String abc) {
        return abc.toUpperCase();
    }

    public boolean anyContains(String str, String searchStr) {

        char[] s = str.toCharArray();
        for (char c : s) {
            if (searchStr.contains(c+"")) {
                return true;
            }
        }
        return false;
    }

}
