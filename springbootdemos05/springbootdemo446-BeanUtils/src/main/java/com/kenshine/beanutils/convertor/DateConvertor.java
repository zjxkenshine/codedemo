package com.kenshine.beanutils.convertor;

import com.tuyang.beanutils.BeanCopyConvertor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author by kenshine
 * @Classname DateConvertor
 * @Description 自定义日期转换
 * @Date 2023-11-01 12:35
 * @modified By：
 * @version: 1.0$
 */
public class DateConvertor implements BeanCopyConvertor<LocalDateTime, String> {
    @Override
    public String convertTo(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
