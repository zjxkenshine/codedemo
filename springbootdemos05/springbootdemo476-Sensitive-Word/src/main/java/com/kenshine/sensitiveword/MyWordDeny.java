package com.kenshine.sensitiveword;

import com.github.houbb.sensitive.word.api.IWordDeny;

import java.util.Arrays;
import java.util.List;

/**
 * 动态敏感词
 */
public class MyWordDeny implements IWordDeny {

    @Override
    public List<String> deny() {
        return Arrays.asList("我的自定义敏感词");
    }

}