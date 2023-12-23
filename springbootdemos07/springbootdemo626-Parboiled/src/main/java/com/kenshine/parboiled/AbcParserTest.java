package com.kenshine.parboiled;

import org.parboiled.Parboiled;
import org.parboiled.common.StringUtils;
import org.parboiled.errors.ErrorUtils;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParsingResult;

import java.util.Scanner;

import static org.parboiled.support.ParseTreeUtils.printNodeTree;

/**
 * @author by kenshine
 * @Classname AbcParserTest
 * @Description abc解析测试
 * @Date 2023-12-23 15:46
 * @modified By：
 * @version: 1.0$
 *
 * a^nb^nc^n n≥1
 *
 * abc数量相同：
 * aabbcc
 * abc
 * aaabbbccc
 * ...
 */
public class AbcParserTest {
    public static void main(String[] args) {
        AbcParser parser = Parboiled.createParser(AbcParser.class);
        while (true) {
            System.out.print("Enter an a^n b^n c^n expression (single RETURN to exit)!\n");
            String input = new Scanner(System.in).nextLine();
            if (StringUtils.isEmpty(input)) {
                break;
            }
            ParsingResult<?> result = new ReportingParseRunner(parser.S()).run(input);
            if (!result.parseErrors.isEmpty()) {
                System.out.println(ErrorUtils.printParseError(result.parseErrors.get(0)));
            } else {
                System.out.println(printNodeTree(result) + '\n');
            }
        }
    }
}
