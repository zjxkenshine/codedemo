package com.kenshine.segment;

import com.github.houbb.segment.api.ISegmentResult;
import com.github.houbb.segment.bs.SegmentBs;
import com.github.houbb.segment.support.format.impl.SegmentFormats;
import com.github.houbb.segment.support.segment.result.impl.SegmentResultHandlers;
import com.github.houbb.segment.util.SegmentHelper;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname SegFormatTest
 * @Description 分词格式化
 * @Date 2023-11-11 13:11
 * @modified By：
 * @version: 1.0$
 */
public class SegFormatTest {

    /**
     * 默认格式
     */
    @Test
    public void test01(){
        String text = "阿Ｑ精神";
        List<ISegmentResult> segmentResults = SegmentHelper.segment(text);
        System.out.println(segmentResults);
    }

    /**
     * 繁体分词
     */
    @Test
    public void test02(){
        String text = "這是一個伸手不見五指的黑夜";
        List<String> defaultWords = SegmentBs.newInstance()
                .segment(text, SegmentResultHandlers.word());
        System.out.println(defaultWords);

        List<String> defaultWords1 = SegmentBs.newInstance()
                .segmentFormat(SegmentFormats.chineseSimple())
                .segment(text, SegmentResultHandlers.word());
        System.out.println(defaultWords1);
    }


    /**
     * 责任链
     */
    @Test
    public void test03(){
        final String text = "阿Ｑ，這是一個伸手不見五指的黑夜";
        List<String> defaultWords = SegmentBs.newInstance()
                .segmentFormat(SegmentFormats.chains(SegmentFormats.defaults(),
                        SegmentFormats.chineseSimple()))
                .segment(text, SegmentResultHandlers.word());
        System.out.println(defaultWords);
    }

}
