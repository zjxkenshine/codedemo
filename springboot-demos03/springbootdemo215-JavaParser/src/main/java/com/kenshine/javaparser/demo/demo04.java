package com.kenshine.javaparser.demo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;

import static com.github.javaparser.ParseStart.EXPRESSION;
import static com.github.javaparser.Providers.provider;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 0:21
 * @description：ParserConfiguration配置
 * @modified By：
 * @version: $
 */
public class demo04 {
    public static void main(String[] args) {
        ParserConfiguration configuration = new ParserConfiguration();
        JavaParser parser = new JavaParser(configuration);
        ParseResult parseResult = parser.parse(EXPRESSION, provider("1+1"));
        if (!parseResult.isSuccessful()) {
            System.out.println(parseResult.getProblems().toString());
        }
        // 解析失败
        parseResult.getResult().ifPresent(System.out::println);
        if (parseResult.getCommentsCollection().isPresent()) {
            //存在注释
        }
    }
}
