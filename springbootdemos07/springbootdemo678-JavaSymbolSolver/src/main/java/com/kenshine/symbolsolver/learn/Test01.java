package com.kenshine.symbolsolver.learn;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DotPrinter;
import com.github.javaparser.printer.XmlPrinter;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description 观察AST 入门
 * @Date 2024-01-13 9:43
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {

    /**
     * 入门，解析代码
     */
    @Test
    public void test01(){
        // 解析代码
        CompilationUnit cu = StaticJavaParser.parse("class X { int x; }");
        // 打印AST语法树
        System.out.println(cu);

        // xml形式打印
        XmlPrinter printer = new XmlPrinter(true);
        System.out.println(printer.output(cu));
    }

    /**
     * 生成dot语言描述的控制流程文件
     * 需要安装graphviz软件转换为png
     * 参考
     * https://blog.csdn.net/weixin_43201090/article/details/111655126
     */
    @Test
    public void test02() throws IOException {
        // 解析代码
        CompilationUnit cu = StaticJavaParser.parse("class X { int x; }");
        // 转储为.dot形式
        DotPrinter printer = new DotPrinter(true);
        try (FileWriter fileWriter = new FileWriter("dot\\ast.dot");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(printer.output(cu));
        }
    }
}
