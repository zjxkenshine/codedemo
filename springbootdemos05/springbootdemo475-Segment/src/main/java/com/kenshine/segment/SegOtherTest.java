package com.kenshine.segment;

import com.github.houbb.segment.api.ISegmentResult;
import com.github.houbb.segment.bs.SegmentBs;
import com.github.houbb.segment.support.tagging.pos.tag.impl.SegmentPosTaggings;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname SegOtherTest
 * @Description 自定义词库，词性，释放资源
 * @Date 2023-11-11 13:18
 * @modified By：
 * @version: 1.0$
 */
public class SegOtherTest {

    /**
     * resources/segment_phrase_dict_define.txt
     * 自定义词库
     * 第一个词是我们自定义的词，必填。
     * 第二个为这个词出现的词频，选填，默认为 3。
     * 第三个为词性，选填，默认为 un。（未知）
     *
     * 用户自定义的词优先级更高，会覆盖系统原有的相同词
     */
    @Test
    public void test01(){
        final String string = "这是一个有彩霞的黄昏。";
        List<ISegmentResult> resultList = SegmentBs.newInstance()
                .posTagging(SegmentPosTaggings.simple())
                .segment(string);
        System.out.println(resultList);
    }

    /**
     * 词性标注
     */
    @Test
    public void test02(){
        final String string = "这是一个伸手不见五指的黑夜。";
        List<ISegmentResult> resultList = SegmentBs.newInstance()
                .posTagging(SegmentPosTaggings.simple())
                .segment(string);
        System.out.println(resultList);
    }

    /**
     * 释放资源
     */
    @Test
    public void test03(){
        // 基本特性
        final SegmentBs segmentBs = SegmentBs.newInstance();
        final String string = "这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱学习。";
        List<ISegmentResult> resultList = segmentBs.segment(string);
        System.out.println(resultList);

        // 资源释放
        segmentBs.destroy();

        // 重新处理
        List<ISegmentResult> resultList2 = segmentBs.segment(string);
        System.out.println(resultList2);
    }

}
