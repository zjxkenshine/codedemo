package bilibili.utilites;

import com.google.common.base.CharMatcher;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 14:57
 * @description： CharMatcher 字符串匹配测试
 * @modified By：
 * @version: $
 *
 * https://blog.csdn.net/qq_17200461/article/details/114239824
 */
public class CharMatcherTest {

    @Test
    public void testCharMatcher(){
        // 判定函数
        System.out.println(CharMatcher.is('a').matchesAllOf("asd"));
        System.out.println(CharMatcher.is('a').matchesNoneOf("aba"));
        System.out.println(CharMatcher.is('a').matchesAnyOf("aba"));

        // 计数函数
        System.out.println(CharMatcher.is('a').countIn("asd"));
        System.out.println(CharMatcher.is('s').indexIn("qws"));

        // 操作匹配字符
        //匹配a和s
        System.out.println(CharMatcher.anyOf("as").retainFrom("asdsdwas")); //assas
        //除去首尾的a和b
        System.out.println(CharMatcher.anyOf("ab").trimFrom("abacatbab")); //cat
        //移除所有a
        System.out.println(CharMatcher.is('a').removeFrom("bazaar")); // bzr
    }

    /**
     * CharMatcher是一个抽象类，调用CharMatcher 的工厂方法可创建CharMatcher：
     * • any()
     * • none()
     * • whitespace()
     * • breakingWhitespace()
     * • invisible()
     * • digit()
     * • javaLetter()
     * • javaDigit()
     * • javaLetterOrDigit()
     * • javaIsoControl()
     * • javaLowerCase()
     * • javaUpperCase()
     * • ascii()
     * • singleWidth()
     * 其它一些常用的获得一个 CharMatcher 的方法包括：
     * anyOf(CharSequence)：表明你想匹配的所有字符，例如：CharMatcher.anyOf(“aeiou”) 可以匹配小写元音字母。
     * is(char)：表明你想匹配的一个确定的字符。
     * inRange(char, char)：表明你想匹配的一个字符范围，例如：CharMatcher.inRange(‘a’, ‘z’)。
     *
     * 使用 CharMatcher
     * CharMatcher 提供了很多方法来对匹配的字符序列 CharSequence 进行操作。以下只是列出了一些常用方法。
     * 方法
     * 描述
     * collapseFrom(CharSequence, char)
     * 将一组连续匹配的字符串替换为一个指定的字符。例如：WHITESPACE.collapseFrom(string, ’ ') 可以将连续的空字符串替换为单个字符。
     * matchesAllOf(CharSequence)
     * 测试字符序列是否全部匹配。例如：ASCII.matchesAllOf(string) 可以测试字符是否全部是 ASCII。
     * removeFrom(CharSequence)
     * 将匹配的字符序列移除
     * retainFrom(CharSequence)
     * 将没有匹配的字符序列移除
     * trimFrom(CharSequence)
     * 去除开头和结尾匹配的部分
     * replaceFrom(CharSequence, CharSequence)
     * 将匹配的字符替换为给定的序列
     */

}
