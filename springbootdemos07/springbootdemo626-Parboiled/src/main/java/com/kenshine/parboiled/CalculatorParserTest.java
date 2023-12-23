package com.kenshine.parboiled;

import org.parboiled.Parboiled;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

/**
 * @author by kenshine
 * @Classname CalculatorParserTest
 * @Description CalculatorParser计算解析测试
 * @Date 2023-12-23 15:22
 * @modified By：
 * @version: 1.0$
 */
public class CalculatorParserTest {
    public static void main(String[] args) {
        String input = "1+2";
        CalculatorParser parser = Parboiled.createParser(CalculatorParser.class);
        ParsingResult<?> result = new ReportingParseRunner<>(parser.Expression()).run(input);
        String parseTreePrintOut = ParseTreeUtils.printNodeTree(result);
        System.out.println(parseTreePrintOut);
    }
}
