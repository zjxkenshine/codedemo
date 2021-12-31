package com.kenshine.javaparser.demo;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.utils.SourceRoot;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 23:33
 * @description：解析项目
 * @modified By：
 * @version: $
 */
public class demo02 {
    public static void main(String[] args) throws IOException {
        // 解析所有源文件
        SourceRoot sourceRoot = new SourceRoot(Paths.get("F:\\IDEAworkespace\\codedemo\\springboot-demos03\\springbootdemo214-CGLib\\src\\main\\java\\com\\kenshine\\cglib\\demo01"));
        sourceRoot.setParserConfiguration(new ParserConfiguration());
        List<ParseResult<CompilationUnit>>  parseResults = sourceRoot.tryToParse("");

        // 获取所有编译单元
        List<CompilationUnit> allCus = parseResults.stream()
                .filter(ParseResult::isSuccessful)
                .map(r -> r.getResult().get())
                .collect(Collectors.toList());


        //long n = getNodes(allCus, MethodDeclaration.class).stream().filter(m -> m.get.getParameters().size() > 3).count();
        //System.out.println("N of methods with 3+ params: " + n);
        System.out.println(allCus);
    }

    //获取所有编译单元中特定类型的所有节点
    public static List<Node> getNodes(List<CompilationUnit> cus, Class nodeClass) {
        List<Node> res = new LinkedList();
        cus.forEach(cu -> res.addAll(cu.findAll(nodeClass)));
        return res;
    }
}
