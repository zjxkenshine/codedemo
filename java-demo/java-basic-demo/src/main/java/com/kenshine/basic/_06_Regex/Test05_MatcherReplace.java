package com.kenshine.basic._06_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 20:40
 * @description：
 * @modified By：
 * @version: $
 *
 * replaceFirst 替换首次匹配，replaceAll 替换所有匹配
 *
 */
public class Test05_MatcherReplace {
    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. All dogs say meow.";
    private static String REPLACE = "cat";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }
}
