package com.kenshine.openregex;

import com.google.common.collect.Lists;
import edu.washington.cs.knowitall.regex.Expression;
import edu.washington.cs.knowitall.regex.RegularExpression;
import edu.washington.cs.knowitall.regex.RegularExpressionParser;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname OpenregexTest
 * @Description 使用测试
 * @Date 2024-03-07 8:31
 * @modified By：
 * @version: 1.0$
 */
public class OpenregexTest {

    /**
     * MinMax 最少/最多出现次数
     */
    @Test
    public void test01(){
        RegularExpression<String> regExZeroToOne = getAbcRegex(0, 1);
        System.out.println(regExZeroToOne);
        boolean b1=regExZeroToOne.apply(Arrays.asList("a","c"));
        boolean b2=regExZeroToOne.apply(Arrays.asList("a","b","c"));
        boolean b3=regExZeroToOne.apply(Arrays.asList("a","b","b","c"));
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }


    public RegularExpressionParser<String> getStringParser(){
        RegularExpressionParser<String> word = new RegularExpressionParser<String>() {
            @Override
            public Expression.BaseExpression<String> factory(final String string) {
                return new Expression.BaseExpression<String>(string) {
                    @Override
                    public boolean apply(String token) {
                        return string.equals(token);
                    }
                };
            }
        };
        return word;
    }

    public RegularExpressionParser<Character> getCharacterParser(){
        return new RegularExpressionParser<Character>() {
            @Override
            public Expression.BaseExpression<Character> factory(final String string) {
                return new Expression.BaseExpression<Character>(string) {
                    @Override
                    public boolean apply(Character token) {
                        return string.equals(token.toString());
                    }
                };
            }
        };
    }

    private RegularExpression<String> getAbcRegex(int min, int max) {
        Expression<String> wordA = getStringParser().parse("<a>").expressions.get(0);
        Expression<String> wordB = getStringParser().parse("<b>").expressions.get(0);
        Expression<String> wordC = getStringParser().parse("<c>").expressions.get(0);
        return RegularExpression.compile(Lists.newArrayList(
                wordA,
                // 最少出现min次，最多出现max次
                new Expression.MinMax<>(wordB, min, max),
                wordC)
        );
    }
}
