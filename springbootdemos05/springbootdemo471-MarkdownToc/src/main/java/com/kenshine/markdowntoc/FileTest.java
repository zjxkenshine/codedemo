package com.kenshine.markdowntoc;

import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;
import com.github.houbb.markdown.toc.vo.TocGen;
import org.junit.Test;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/10 21:41
 * @description：Markdown文件
 * @modified By：
 * @version: $
 */
public class FileTest {

    /**
     * 为springbootdemo471.md文件生成目录
     */
    @Test
    public void test01(){
        String path = "F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo471-MarkdownToc\\springbootdemo471.md";
        TocGen tocGen = AtxMarkdownToc.newInstance()
                .charset("UTF-8")
                // 	是否将 toc 写入文件(默认写入)
                .write(true)
                // 是否包含子文件夹的文件(默认包含)
                .subTree(true)
                .genTocFile(path);
        System.out.println(tocGen);
    }

    /**
     * 指定文件夹
     */
    @Test
    public void test02(){
        String path="F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo471-MarkdownToc";
        List<TocGen> tocGens = AtxMarkdownToc.newInstance()
                .subTree(false)
                .genTocDir(path);

        System.out.println(tocGens.size());
    }
}
