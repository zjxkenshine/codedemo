package com.kenshine.generex;

import com.mifmif.common.regex.Generex;
import com.mifmif.common.regex.util.Iterator;

import java.util.List;

/**
 * @author by kenshine
 * @Classname GenerexTest
 * @Description 正则表达式测试
 * @Date 2023-11-13 8:12
 * @modified By：
 * @version: 1.0$
 */
public class GenerexTest {
    public static void main(String[] args) {
        Generex generex = new Generex("[0-3]([a-c]|[e-g]{1,2})");

        // 随机一个匹配字符串
        String randomStr = generex.random();
        System.out.println(randomStr);

        // 第二个匹配的字符串
        String secondString = generex.getMatchedString(2);
        System.out.println(secondString);

        // 所有匹配字符串
        List<String> matchedStrs = generex.getAllMatchedStrings();
        System.out.println(matchedStrs);

        // 迭代器
        Iterator iterator = generex.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
