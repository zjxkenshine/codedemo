package com.kenshine.oro;

import org.apache.oro.text.regex.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname OroTest
 * @Description Oro简单使用示例
 * @Date 2023-12-26 8:55
 * @modified By：
 * @version: 1.0$
 */
public class OroTest {

    /**
     * 字符串匹配
     */
    @Test
    public void test01() throws MalformedPatternException {
        String content="['kevin][名词]（人名凯文）{(Kevinloves comic./凯文爱漫画/名词:凯文)(Kevin is living in ZhuHai now. /凯文现住在珠海/名词:凯文)}";
        String ps1 = "{.+}";
        String ps2="([^)]+)";
        String ps3="([^(]+)/(.+)/(.+):([^)]+)";
        String sentence;
        PatternCompiler orocom = new Perl5Compiler();
        Pattern pattern1 = orocom.compile(ps1);
        Pattern pattern2 = orocom.compile(ps2);
        Pattern pattern3 = orocom.compile(ps3);

        PatternMatcher matcher = new Perl5Matcher();
        //先找出整个例句部分
        if (matcher.contains(content, pattern1)) {
            MatchResult result = matcher.getMatch();
            String example = result.toString();
            PatternMatcherInput input = new PatternMatcherInput(example);
            //分别找出例句一和例句二
            while (matcher.contains(input, pattern2)) {
                result = matcher.getMatch();
                sentence = result.toString();
                //把每个例句里的各项用分组的办法分隔出来
                if (matcher.contains(sentence, pattern3)) {
                    result = matcher.getMatch();
                    System.out.println("英文句: " + result.group(1));
                    System.out.println("句子中文翻译: " + result.group(2));
                    System.out.println("词性: " + result.group(3));
                    System.out.println("意思: " + result.group(4));
                }
            }
        }
    }

    /**
     * 字符串替换
     */
    @Test
    public void test02() throws MalformedPatternException {
        String content="['kevin][名词]（人名凯文）{(Kevinloves comic./凯文爱漫画/名词:凯文)(Kevin is living in ZhuHai now. /凯文现住在珠海/名词:凯文)}";
        String ps1="([^(]+)/(.+)/(.+):([^)]+)";
        PatternCompiler orocom=new Perl5Compiler();
        Pattern pattern1=orocom.compile(ps1);
        PatternMatcher matcher=new Perl5Matcher();
        // 在第1次匹配的时候进行替换
        String result=Util.substitute(matcher, pattern1,new Perl5Substitution("{$1( Kevin has seen《LEON》 seveal times,because it is a good film./凯文已经看过《这个杀手不太冷》几次了，因为它是一部好电影。/名词: 凯文。 )}",1),
        content,Util.SUBSTITUTE_ALL);
        System.out.println(result);
    }

}
