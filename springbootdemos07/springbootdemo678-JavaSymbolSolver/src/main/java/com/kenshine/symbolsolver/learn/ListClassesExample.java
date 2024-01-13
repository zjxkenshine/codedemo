package com.kenshine.symbolsolver.learn;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import com.kenshine.symbolsolver.learn.support.DirExplorer;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 遍历类 visitor方式
 * @author kenshine
 */
public class ListClassesExample {

    public static void listClasses(File projectDir) throws FileNotFoundException {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            new VoidVisitorAdapter<Object>() {
                @Override
                public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                    super.visit(n, arg);
                    System.out.println(" * " + n.getName());
                }
            }.visit(StaticJavaParser.parse(file), null);
        }).explore(projectDir);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File projectDir = new File("D:/Github/codedemo/springbootdemos07");
        listClasses(projectDir);
    }
}