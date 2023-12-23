package com.kenshine.parboiled;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

/**
 * @author by kenshine
 * @Classname AbcParser
 * @Description A
 * @Date 2023-12-23 15:42
 * @modified By：
 * @version: 1.0$
 *
 * S <- &(A c) a+ B !(a|b|c)
 * A <- a A? b
 * B <- b B? c
 */
@BuildParseTree
public class AbcParser extends BaseParser<Object> {
    public Rule S() {
        // 顺序
        return Sequence(
                // &(A c)
                Test(A(), 'c'),
                // a+
                OneOrMore('a'),
                B(),
                // !(a|b|c)
                TestNot(AnyOf("abc"))
        );
    }
    public Rule A() {
        return Sequence('a', Optional(A()), 'b');
    }
    public Rule B() {
        return Sequence('b', Optional(B()), 'c');
    }
}
