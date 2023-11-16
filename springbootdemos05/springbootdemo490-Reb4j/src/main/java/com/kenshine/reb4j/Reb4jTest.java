package com.kenshine.reb4j;

import io.github.reggert.reb4j.*;
import io.github.reggert.reb4j.charclass.CharClass;
import static io.github.reggert.reb4j.charclass.CharClass.Perl;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author by kenshine
 * @Classname Reb4jTest
 * @Description 测试reb4j生成正则表达式
 * @Date 2023-11-16 17:29
 * @modified By：
 * @version: 1.0$
 */
public class Reb4jTest {
    /**
     * 正则表达式生成
     */
    @Test
    public void test(){
        // DIGIT 任意数字
        final Alternative oneDigitOctet = Perl.DIGIT;
        System.out.println(oneDigitOctet.toString());

        // 1-9任意数字
        final Alternative twoDigitOctet = CharClass.range('1', '9').andThen(Perl.DIGIT);
        System.out.println(twoDigitOctet.toString());

        // Literal匹配字符串
        final Alternation threeDigitOctet = Alternation.alternatives(
                // 1+任意数字重复2次
                Literal.literal('1').andThen(Perl.DIGIT.repeat(2)),
                // 组合匹配 2[0-4] 数字
                Sequence.sequence(Literal.literal('2'), CharClass.range('0', '4'), Perl.DIGIT),
                // 25[0-5]
                Literal.literal("25").andThen(CharClass.range('0', '5'))
        );
        System.out.println(threeDigitOctet.toString());

        // 组合
        final Alternation octet = Alternation.alternatives( oneDigitOctet, twoDigitOctet, threeDigitOctet );
        // 匹配.
        final CharLiteral dot = Literal.literal('.');
        // 拼接最终正则表达式
        final Sequence dottedDecimalIPAddress = Sequence.sequence(
                Group.capture(octet),
                dot,
                Group.capture(octet),
                dot,
                Group.capture(octet),
                dot,
                Group.capture(octet)
        );
        System.out.println(octet.toString());
        System.out.println(dottedDecimalIPAddress.toString());

        // 转换为Pattern
        final Pattern pattern = dottedDecimalIPAddress.toPattern();
        final String input = "1.2.3.4";
        // 匹配
        final Matcher matcher = pattern.matcher(input);
        final int[] octets;
        if (matcher.matches()){
            octets = new int[4];
            for (int i = 0; i < 4; i++){
                // octets = {1, 2, 3, 4}
                octets[i] = Integer.parseInt(matcher.group(i+1));
            }
        } else {
            octets = null;
        }
    }
}
