package com.kenshine.basic._06_Regex;

import java.util.regex.Pattern;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 20:17
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01_RegexExample {
    public static void main(String[] args) {
        String content = "I am noob from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
}
