package com.kenshine.cosid.converter;

import me.ahoo.cosid.IdConverter;

/**
 * @author by kenshine
 * @Classname CustomIdConverter
 * @Description 自定义id转换
 * @Date 2023-10-25 12:01
 * @modified By：
 * @version: 1.0$
 */
public class CustomIdConverter implements IdConverter {
    @Override
    public String asString(long id) {
        return String.valueOf(id);
    }

    @Override
    public long asLong(String idString) {
        return Long.getLong(idString);
    }
}
