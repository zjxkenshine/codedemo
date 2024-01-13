package com.kenshine.symbolsolver.learn.lexical;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname LexicalTest
 * @Description javaParser实现词法保留
 * @Date 2024-01-13 12:42
 * @modified By：
 * @version: 1.0$
 */
public class LexicalTest {

    /**
     * 词法保留解析
     */
    @Test
    public void test01(){
        String originalCode = "class A { int a; }";
        // 解析java代码
        CompilationUnit cu = StaticJavaParser.parse(originalCode);
        // 获取LexicalPreservingPrinter
        // 做了两件事 1.关联AST起始代码
        // 2.注册了ASTObserver
        CompilationUnit lpp = LexicalPreservingPrinter.setup(cu);
        // 执行变动 设置初始化
        lpp.getClassByName("A").get().getFieldByName("a").get().getVariable(0).setInitializer("10");
        // 获取转换代码
        String transformedCode = LexicalPreservingPrinter.print(lpp);
        System.out.println(transformedCode);
    }

}
