package com.kenshine.basic._06_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 20:42
 * @description：
 * @modified By：
 * @version: $
 */
public class Test06_MatcherAppend {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoobkkk";
    private static String REPLACE = "-";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
