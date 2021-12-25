package com.kenshine.jcommander.demo03;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterFactory;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:44
 * @description：自定义转换器工厂
 * @modified By：
 * @version: $
 */
public class HostPortFactory implements IStringConverterFactory {
    @Override
    public Class<? extends IStringConverter<?>> getConverter(Class forType) {
        if (forType.equals(HostPort.class)) {
            return HostPortConverter.class;
        } else {
            return null;
        }
    }
}
