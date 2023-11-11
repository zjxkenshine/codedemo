package com.kenshine.segment;

import com.github.houbb.segment.api.ISegmentResult;
import com.github.houbb.segment.bs.SegmentBs;
import com.github.houbb.segment.support.segment.mode.impl.SegmentModes;
import com.github.houbb.segment.support.segment.result.impl.SegmentResultHandlers;
import com.github.houbb.segment.util.SegmentHelper;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname SegTest
 * @Description 分词使用
 * @Date 2023-11-11 12:35
 * @modified By：
 * @version: 1.0$
 */
public class SegModelTest {

    /**
     * 分词测试
     */
    @Test
    public void test01(){
        final String string = "这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱学习。";
        List<ISegmentResult> resultList = SegmentHelper.segment(string);
        System.out.println(resultList);
    }


    /**
     * 获取分词信息
     */
    @Test
    public void test02(){
        final String string = "这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱学习。";
        List<String> resultList = SegmentHelper.segment(string, SegmentResultHandlers.word());
        System.out.println(resultList);
    }

    /**
     * 统计次数
     */
    @Test
    public void test03(){
        final String string = "这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱学习。";
        Map<String, Integer> wordCount = SegmentHelper.segment(string, SegmentResultHandlers.wordCount());
        System.out.println(wordCount);
        Map<String, Integer> wordCount1 = SegmentHelper.wordCount(string);
        System.out.println(wordCount1);
    }


    /**
     * search分词模式
     */
    @Test
    public void testSearch(){
        final String string = "这是一个伸手不见五指的黑夜。";
        List<ISegmentResult> resultList = SegmentBs.newInstance()
                .segmentMode(SegmentModes.search())
                .segment(string);
        System.out.println(resultList);
    }

    /**
     * Dict
     * 只依赖词库实现分词，没有 HMM 新词预测功能
     */
    @Test
    public void testDict(){
        final String string = "这是一个伸手不见五指的黑夜。";
        List<ISegmentResult> resultList = SegmentBs.newInstance()
                .segmentMode(SegmentModes.dict())
                .segment(string);
        System.out.println(resultList);
    }

    /**
     * Index分词
     * 这里主要的区别就是会返回 伸手、伸手不见 等其他词组
     */
    @Test
    public void testIndex(){
        final String string = "这是一个伸手不见五指的黑夜。";
        List<ISegmentResult> resultList = SegmentBs.newInstance()
                .segmentMode(SegmentModes.index())
                .segment(string);
        System.out.println(resultList);
    }


    /**
     * 贪心算法实现，准确率一般，性能较好
     * GreedyLength
     */
    @Test
    public void testGreedyLength(){
        final String string = "这是一个伸手不见五指的黑夜。";
        List<ISegmentResult> resultList = SegmentBs.newInstance()
                .segmentMode(SegmentModes.greedyLength())
                .segment(string);
        System.out.println(resultList);
    }
}
