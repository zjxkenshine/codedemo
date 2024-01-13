package com.kenshine.symbolsolver.learn;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.observer.PropagatingAstObserver;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import com.kenshine.symbolsolver.learn.support.DirExplorer;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 提取方法调用
 * @author kenshine
 */
public class MethodCallsExample {
    public static void listMethodCalls(File projectDir) throws FileNotFoundException {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            new VoidVisitorAdapter<Object>() {
                @Override
                public void visit(MethodCallExpr n, Object arg) {
                    super.visit(n, arg);
                    System.out.println(" [L " + n.getBegin().get().line + "] " + n);
                }
            }.visit(StaticJavaParser.parse(file), null);
            System.out.println();
        }).explore(projectDir);
    }
    public static void main(String[] args) throws FileNotFoundException {
        File projectDir = new File("D:/Github/codedemo/springbootdemos07/springbootdemo678-JavaSymbolSolver");
        listMethodCalls(projectDir);
    }
}