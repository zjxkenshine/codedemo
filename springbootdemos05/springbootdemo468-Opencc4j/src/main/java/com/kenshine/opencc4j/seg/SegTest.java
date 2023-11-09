package com.kenshine.opencc4j.seg;

import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import com.github.houbb.opencc4j.support.segment.Segment;

/**
 * @author by kenshine
 * @Classname SegTest
 * @Description 自定义分词
 * @Date 2023-11-09 12:24
 * @modified By：
 * @version: 1.0$
 */
public class SegTest {
    public static void main(String[] args) {
        final String original = "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。";
        final Segment segment = new FooSegment();

        final String result = ZhConvertBootstrap.newInstance()
                .segment(segment)
                .toTraditional(original);

        System.out.println(result);
    }
}
