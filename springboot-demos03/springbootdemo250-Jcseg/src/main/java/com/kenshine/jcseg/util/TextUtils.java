package com.kenshine.jcseg.util;

import org.lionsoul.jcseg.ISegment;
import org.lionsoul.jcseg.IWord;
import org.lionsoul.jcseg.dic.ADictionary;
import org.lionsoul.jcseg.dic.DictionaryFactory;
import org.lionsoul.jcseg.extractor.SummaryExtractor;
import org.lionsoul.jcseg.extractor.impl.TextRankSummaryExtractor;
import org.lionsoul.jcseg.segmenter.SegmenterConfig;
import org.lionsoul.jcseg.sentence.SentenceSeg;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author by kenshine
 * @Classname TextUtils
 * @Description 分词工具
 * @Date 2023-10-11 11:55
 * @modified By：
 * @version: 1.0$
 */
public class TextUtils {
    private static final SegmenterConfig config;
    private static final ADictionary dic;
    private static final ISegment seg;

    static {
        // 创建配置实例,使用默认配置传递true
        config = new SegmenterConfig(true);
        //创建默认单例词库实现，并且按照config配置加载词库
        dic = DictionaryFactory.createSingletonDictionary(config);
        //依据给定的ADictionary和SegmenterConfig来创建ISegment
        //这里创建的是NLP切分模式,它基于复杂模式添加人名、邮箱、电话等等切分
        seg = ISegment.NLP.factory.create(config, dic);
    }

    /**
     * 分词
     * @param text 文本
     * @return 分词结果
     * @throws IOException io异常
     */
    public static String wordSegmentation(String text) throws IOException {
        //备注：以下代码可以反复调用，seg为非线程安全
        //设置要被分词的文本
        seg.reset(new StringReader(text));
        //获取分词结果
        IWord word;
        StringBuilder sb = new StringBuilder();
        while ((word = seg.next()) != null) {
            sb.append(word.getValue()).append("|");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 截取摘要
     * @param text 文本
     * @param length 摘要长度
     * @return 摘要
     * @throws IOException io异常
     */
    public static String getSummary(String text, int length) throws IOException {
        SummaryExtractor extractor = new TextRankSummaryExtractor(seg, new SentenceSeg());
        return extractor.getSummary(new StringReader(text), length);
    }
}
