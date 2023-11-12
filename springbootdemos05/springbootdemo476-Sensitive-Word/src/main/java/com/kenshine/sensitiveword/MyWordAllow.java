package com.kenshine.sensitiveword;

import com.github.houbb.sensitive.word.api.IWordAllow;

import java.util.Arrays;
import java.util.List;

/**
 * 动态敏感词白名单
 */
public class MyWordAllow implements IWordAllow {

    @Override
    public List<String> allow() {
        return Arrays.asList("五星红旗");
    }

}