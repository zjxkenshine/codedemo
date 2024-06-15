package com.kenshine.mapstructplus.converter;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author kenshine
 * 自定义转换器 String转List
 */
@Component
public class StringToListStringConverter {
    public static List<String> stringToListString(String str) {
        return Arrays.asList(StringUtils.split(str, ","));
    }
}