package com.kenshine.symbolsolver.learn;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.javadoc.Javadoc;
import org.junit.Test;

import static com.github.javaparser.ParseStart.COMPILATION_UNIT;
import static com.github.javaparser.ParseStart.EXPRESSION;
import static com.github.javaparser.Providers.provider;
import static com.github.javaparser.StaticJavaParser.*;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description JavaParser与StaticJavaParser
 * @Date 2024-01-13 10:09
 * @modified By：
 * @version: 1.0$
 */
public class Test02 {

    /**
     * 基本介绍
     */
    @Test
    public void test01(){
        // StaticJavaParser的parse方法
        // 可以有各种输入，如文件，inputstream等
        // 解析失败报ParseProblemException
        CompilationUnit cu = parse("class X{}");
        System.out.println(cu);
        // 解析表达式
        Expression e = parseExpression("1+1");
        System.out.println(e);
        // 解析doc
        Javadoc javadoc =parseJavadoc("class X{}");
        System.out.println(javadoc);

        // StaticJavaParser.getParserConfiguration解析配置
        StaticJavaParser.getParserConfiguration().setAttributeComments(false);
        CompilationUnit cu1 = parse("class X{}");
        System.out.println(cu1);
    }

    /**
     * JavaParser 使用方式1
     */
    @Test
    public void test02(){
        JavaParser javaParser = new JavaParser();
        // ParseResult存放解析结果
        ParseResult result = javaParser.parse(COMPILATION_UNIT, provider("class X{}"));
        result.ifSuccessful(cu ->
                System.out.println(cu)
        );
    }

    /**
     * JavaParser 使用方式2
     * JavadocParser解析doc
     */
    @Test
    public void test03(){
        new JavaParser().parse(COMPILATION_UNIT, provider("class X{}")).ifSuccessful(cu ->
                System.out.println(cu)
        );
    }

    /**
     * ParserConfiguration 解析配置
     */
    @Test
    public void test04(){
        // 解析配置
        ParserConfiguration configuration = new ParserConfiguration();
        JavaParser parser = new JavaParser(configuration);
        // 解析表达式
        ParseResult parseResult = parser.parse(EXPRESSION, provider("1+1"));
        if (!parseResult.isSuccessful()) {
            System.out.println(parseResult.getProblems().toString());
        }
        // 解析失败并不意味着没有输出
        parseResult.getResult().ifPresent(System.out::println);
        if (parseResult.getCommentsCollection().isPresent()) {
        }
    }


}
