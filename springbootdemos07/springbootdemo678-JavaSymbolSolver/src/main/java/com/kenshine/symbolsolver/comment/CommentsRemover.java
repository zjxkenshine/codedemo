package com.kenshine.symbolsolver.comment;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname CommentsRemover
 * @Description 移除代码注释工具类
 * @Date 2024-01-13 13:38
 * @modified By：
 * @version: 1.0$
 */
public class CommentsRemover {
    private CommentsRemover() {}
    // 执行
    public static String doAction(String content) {
        JavaParser javaParser = createJavaParser();
        ParseResult<CompilationUnit> result = javaParser.parse(content);
        Optional<CompilationUnit> optionalCompilationUnit = result.getResult();
        if (!optionalCompilationUnit.isPresent()) {
            return "";
        }
        CompilationUnit compilationUnit = optionalCompilationUnit.get();
        removeComments(compilationUnit);
        return LexicalPreservingPrinter.print(compilationUnit);
    }

    public static String doAction(File file) throws FileNotFoundException {
        JavaParser javaParser = createJavaParser();
        ParseResult<CompilationUnit> result = javaParser.parse(file);
        Optional<CompilationUnit> optionalCompilationUnit = result.getResult();
        if (!optionalCompilationUnit.isPresent()) {
            return "";
        }
        CompilationUnit compilationUnit = optionalCompilationUnit.get();
        removeComments(compilationUnit);
        return LexicalPreservingPrinter.print(compilationUnit);
    }

    // 移除注释
    private static void removeComments(CompilationUnit compilationUnit) {
        List<Comment> comments = compilationUnit.getAllContainedComments();
        List<Comment> unwantedComments = comments
                .stream()
                .filter(CommentsRemover::isValidCommentType)
                .collect(Collectors.toList());
        unwantedComments.forEach(Node::remove);
    }
    /**
     * 创建源码解析器。我们设置LexicalPreservationEnabled为true，保留源码中的所有语法。
     */
    private static JavaParser createJavaParser() {
        ParserConfiguration parserConfiguration = new ParserConfiguration();
        parserConfiguration.setLexicalPreservationEnabled(true);
        return new JavaParser(parserConfiguration);
    }

    /**
     * 我们只识别单行注释和块注释
     */
    private static boolean isValidCommentType(Comment comment) {
        return comment instanceof LineComment || comment instanceof BlockComment;
    }
}
