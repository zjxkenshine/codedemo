package com.kenshine.symbolsolver.learn;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.resolution.SymbolResolver;
import com.github.javaparser.symbolsolver.utils.SymbolSolverCollectionStrategy;
import com.github.javaparser.utils.ParserCollectionStrategy;
import com.github.javaparser.utils.ProjectRoot;
import com.github.javaparser.utils.SourceRoot;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author by kenshine
 * @Classname Test03
 * @Description 一次性分析整个项目
 * @Date 2024-01-13 10:28
 * @modified By：
 * @version: 1.0$
 */
public class Test03 {

    /**
     * 解析整个项目
     * SourceRoot 解析java代码
     * 设置roots路径并循环处理
     */
    @Test
    public void test01() throws IOException {
        Path projectRoot = Paths.get("D:\\Github\\codedemo\\springbootdemos07");
        String[] roots = new String[]{
                "springbootdemo677-Kbop/src/main/java",
                "springbootdemo676-Json-Verifier/src/test/java",
                "springbootdemo675-Json-Rules/src/main/java",
        };
        for (String root : roots) {
            // sourceRoot解析
            SourceRoot sourceRoot = new SourceRoot(projectRoot.resolve(root));
            List<ParseResult<CompilationUnit>> parseResults = sourceRoot.tryToParse();
            System.out.println(parseResults);
            // 解析结果打印
            for(ParseResult<CompilationUnit> result:parseResults){
                System.out.println(result.getResult());
            }
        }
    }

    /**
     * ProjectRoot 路径封装
     */
    @Test
    public void test02(){
        // 代码路径
        ProjectRoot projectRoot = new ParserCollectionStrategy().collect(Paths.get("D:\\Github\\codedemo\\springbootdemos07"));
        System.out.println(projectRoot);
        // 包含符号路径
        ProjectRoot projectRoot1 = new SymbolSolverCollectionStrategy().collect(Paths.get("D:\\Github\\codedemo\\springbootdemos07"));
        System.out.println(projectRoot1);
    }
}
