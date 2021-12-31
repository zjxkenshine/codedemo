package com.kenshine.javaparser.demo;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 23:47
 * @description：
 * @modified By：
 * @version: $
 */
public class demo03 {
    public static void main(String[] args) {
        //最小的类型解析器
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        //配置javaParser以使用类型解析
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);

        //解析为编译单元
        CompilationUnit cu = StaticJavaParser.parse("class X { int x() { return 1 + 1.0 - 5; } }");

        // 找出所有表达式的运算
        cu.findAll(BinaryExpr.class).forEach(be -> {
            // 解析的类型
            ResolvedType resolvedType = be.calculateResolvedType();
            /**
             * 1 + 1.0 - 5 is a: PrimitiveTypeUsage{name='double'}
             * 1 + 1.0 is a: PrimitiveTypeUsage{name='double'}
             */
            System.out.println(be.toString() + " is a: " + resolvedType);
        });
    }
}
