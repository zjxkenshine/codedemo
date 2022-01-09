package com.kenshine.basic._06_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 20:31
 * @description：
 * @modified By：
 * @version: $
 */
public class Test03_MatcherStartEnd {
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat cat cattie cat";

    public static void main( String[] args ){
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }
}
