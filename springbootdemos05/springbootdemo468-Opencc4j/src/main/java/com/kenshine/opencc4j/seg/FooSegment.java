package com.kenshine.opencc4j.seg;

import com.github.houbb.opencc4j.support.segment.Segment;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义分词
 * @author kenshine
 */
public class FooSegment implements Segment {
    @Override
    public List<String> seg(String original) {
        return Arrays.asList(original, "测试");
    }
}