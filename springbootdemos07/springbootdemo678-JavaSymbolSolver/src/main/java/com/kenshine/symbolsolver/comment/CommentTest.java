package com.kenshine.symbolsolver.comment;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author by kenshine
 * @Classname CommentTest
 * @Description 使用javaParser移除注释
 * @Date 2024-01-13 13:41
 * @modified By：
 * @version: 1.0$
 */
public class CommentTest {
    /**
     * 移除代码注释测试
     */
    @Test
    public void test01() throws FileNotFoundException {
        // 移除注释 并打印
        String code =CommentsRemover.doAction(new File("src/main/java/com/kenshine/symbolsolver/comment/Input.java"));
        System.out.println(code);
    }
}
