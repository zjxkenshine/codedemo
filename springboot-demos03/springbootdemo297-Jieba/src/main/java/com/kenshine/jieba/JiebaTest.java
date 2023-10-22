package com.kenshine.jieba;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/22 14:36
 * @description：测试
 * @modified By：
 * @version: $
 */
public class JiebaTest {

    @Test
    public void test01(){
        String content = "中国经济新亮点不断涌现";
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> result = segmenter.sentenceProcess(content);
        System.out.println("分词：" + result );
        //分词结果->分词：
    }

    /**
     *  自定义分词
     */
    @Test
    public void test02(){
        String content = "赵丽颖杨幂迪丽热巴古力娜扎鞠婧祎";
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> result = segmenter.sentenceProcess(content);
        System.out.println("分词：" + result);
        // 自定义分词器
        // 格式为：一个词占一行；每一行分三部分：词语、词频（可省略）、词性（可省略），用空格隔开，顺序不可颠倒
        Path path = Paths.get("test.txt");
        WordDictionary.getInstance().loadUserDict(path);
        List<String> result2 = segmenter.sentenceProcess(content);
        System.out.println("自定义分词：" + result2);
        //去除标点符号
        result.toString().replaceAll("[\\pP‘’“”]", "");
    }
}
