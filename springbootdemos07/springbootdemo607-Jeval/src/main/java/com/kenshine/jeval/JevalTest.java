package com.kenshine.jeval;

import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname JevalTest
 * @Description Jeval表达式解析示例
 * @Date 2023-12-20 12:34
 * @modified By：
 * @version: 1.0$
 */
public class JevalTest {

    /**
     * 变量设置
     */
    @Test
    public void test01() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        evaluator.putVariable("a", "'Hello'");
        evaluator.putVariable("b", "'World'");
        System.out.println(evaluator.evaluate("#{a}"));
        System.out.println(evaluator.evaluate("#{b}"));
        // 预置的数学变量
        System.out.println(evaluator.evaluate("#{PI}"));
        System.out.println(evaluator.evaluate("#{a} + ' ' + #{b} + '!'"));
    }

    /**
     * 字符串拼接
     */
    @Test
    public void test02() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        System.out.println(evaluator.evaluate("'A' + 'C'"));
        System.out.println(evaluator.evaluate("'A' < 'C'"));
        // 双引号
        evaluator.setQuoteCharacter(EvaluationConstants.DOUBLE_QUOTE);
        System.out.println(evaluator.evaluate("\"AB\" + \"C\""));
    }


    /**
     * 布尔运算
     */
    @Test
    public void test03() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        System.out.println(evaluator.evaluate("3 < 3"));
        System.out.println(evaluator.evaluate("3 < 4"));
        System.out.println(evaluator.evaluate("((2 < 3) || (1 == 1)) && (3 < 3)"));
    }

    /**
     * 自定义函数执行
     */
    @Test
    public void test04() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        evaluator.putFunction(new TestFunction());
        System.out.println(evaluator.evaluate("stringReverse('Hello World!')"));
        System.out.println(evaluator.evaluate("'*' + stringReverse('test') + '*'"));
    }

    /**
     * 字符串内置函数
     */
    @Test
    public void test05() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        System.out.println(evaluator.evaluate("toLowerCase('Hello World!')"));
        System.out.println(evaluator.evaluate("trim('abc ') + 'd'"));
        System.out.println(evaluator.evaluate("eval(1 + 2)"));
        System.out.println(evaluator.evaluate("lastIndexOf('abcabcabc', 'abc', 8)"));
        // 多层
        System.out.println(evaluator.evaluate("toUpperCase(trim( trim(' a b c ') ))"));
    }

    /**
     * 循环解析计算
     */
    @Test
    public void test06() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        List<List<Long>> table = new ArrayList<>();
        loadData(table, 50, 3);
        String expression = "#{a} >= 2 && #{b} >= 5 && #{c} >= 8";

        int numRows = table.size();
        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            List<Long> row = table.get(rowNum);
            Long a = row.get(0);
            Long b = row.get(1);
            Long c = row.get(2);
            evaluator.putVariable("a", a.toString());
            evaluator.putVariable("b", b.toString());
            evaluator.putVariable("c", c.toString());

            String result = evaluator.evaluate(expression);
            if (result.equals(EvaluationConstants.BOOLEAN_STRING_TRUE)) {
                System.out.println("Row number " + rowNum
                        + " meets our criteria. A=" + a + " B=" + b + " C="
                        + c);
            }
        }
    }

    /**
     * 数学公式解析
     */
    @Test
    public void test07() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        System.out.println(evaluator.evaluate("abs(-1)"));
        System.out.println(evaluator.evaluate("1 + abs(-1)"));
        System.out.println(evaluator.evaluate("acos(0.1)"));
    }

    /**
     * 自定义参数解析
     */
    @Test
    public void test08() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        evaluator.clearVariables();
        evaluator.setVariableResolver(new TestResolver());
        System.out.println(evaluator.evaluate("#{v1} + #{v2}"));
        System.out.println(evaluator.evaluate("#{v1} + 100"));
        System.out.println(evaluator.evaluate("#{v1} + #{null}"));
    }

    /**
     * 随机生成0-10的数据
     */
    private static void loadData(final List<List<Long>> table, final int numRows, final int numColumns) {
        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            final List<Long> row = new ArrayList<>();
            for (int columnNum = 0; columnNum < numColumns; columnNum++) {
                final Long dataValue = Math.round(Math.random() * 10);
                row.add(dataValue);
            }
            table.add(row);
        }
    }

}
