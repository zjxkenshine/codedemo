package com.kenshine.springshell.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 20:40
 * @description：
 * @modified By：
 * @version: $
 */
// 自定义类型转换器
@Component
public class MyConverter implements Converter<String, Food> {
    @Override
    public Food convert(String s) {
        // 将输入参数转换为Food类型实例
        return new Food(s);
    }
}
