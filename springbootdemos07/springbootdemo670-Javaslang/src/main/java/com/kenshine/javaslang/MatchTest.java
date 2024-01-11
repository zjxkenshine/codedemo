package com.kenshine.javaslang;

import org.junit.Test;

import static javaslang.API.*;
import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname MatchTest
 * @Description 匹配
 * @Date 2024-01-11 10:43
 * @modified By：
 * @version: 1.0$
 */
public class MatchTest {
    /**
     * 模式匹配示例1
     */
    @Test
    public void test01(){
        int input = 2;
        // 匹配2
        String output = javaslang.API.Match(input).of(
                // 可用Predicates中的方法进行判断
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(3), "three"),
                Case($(), "?"));
        assertEquals("two", output);
    }
}
