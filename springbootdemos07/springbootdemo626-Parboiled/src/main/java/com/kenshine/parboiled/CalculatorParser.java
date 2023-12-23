package com.kenshine.parboiled;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

/**
 * @Classname CalculatorParser
 * @Description 简单示例
 * @Date 2023-12-23 15:12
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 */
@BuildParseTree
class CalculatorParser extends BaseParser<Object> {
    /**
     *  规则构建
     *  10以内的算法
     */
    Rule Expression() {
        return Sequence(
                Term(),
                ZeroOrMore(AnyOf("+-"), Term())
        );
    }
    Rule Term() {
        return Sequence(
                Factor(),
                ZeroOrMore(AnyOf("*/"), Factor())
        );
    }
    Rule Factor() {
        return FirstOf(
                Number(),
                Sequence('(', Expression(), ')')
        );
    }
    Rule Number() {
        return OneOrMore(CharRange('0', '9'));
    }
}
