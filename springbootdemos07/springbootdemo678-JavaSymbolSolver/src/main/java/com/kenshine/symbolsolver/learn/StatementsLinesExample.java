package com.kenshine.symbolsolver.learn;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.Statement;
import com.google.common.base.Strings;
import com.kenshine.symbolsolver.learn.support.DirExplorer;
import com.kenshine.symbolsolver.learn.support.NodeIterator;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 返回组成语句的行号并打印语句
 * @author kenshine
 */
public class StatementsLinesExample {
    public static void statementsByLine(File projectDir) throws FileNotFoundException {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            new NodeIterator(new NodeIterator.NodeHandler() {
                @Override
                public boolean handle(Node node) {
                    if (node instanceof Statement) {
                        System.out.println(" [Lines " + node.getBegin().get().line + " - " + node.getEnd().get().line + " ] " + node);
                        return false;
                    } else {
                        return true;
                    }
                }
            }).explore(StaticJavaParser.parse(file));
            System.out.println();
        }).explore(projectDir);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File projectDir = new File("D:/Github/codedemo/springbootdemos07/springbootdemo678-JavaSymbolSolver");
        statementsByLine(projectDir);
    }
}