package com.kenshine.javaparser.demo;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 0:26
 * @description：
 * @modified By：
 * @version: $
 */
public class demo05 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream in = new FileInputStream("F:\\IDEAworkespace\\codedemo\\springboot-demos03\\springbootdemo215-JavaParser\\src\\main\\java\\com\\kenshine\\javaparser\\demo\\demo04.java");
        CompilationUnit cu = StaticJavaParser.parse(in);

        // 打印方法名
        new MethodVisitor().visit(cu, null);
    }

    /**
     * 简单的方法访问
     */
    private static class MethodVisitor extends VoidVisitorAdapter {
        @Override
        public void visit(MethodDeclaration n, Object arg) {
            // 方法定义
            System.out.println(n);
            //方法上的注解列表
            System.out.println(n.getAnnotations());
            //方法体
            System.out.println(n.getBody());
            //方法名
            System.out.println(n.getName());
            //MethodDeclaration
            System.out.println(n.getMetaModel());
            //方法中的注释
            System.out.println(n.getAllContainedComments());
        }
    }
}
