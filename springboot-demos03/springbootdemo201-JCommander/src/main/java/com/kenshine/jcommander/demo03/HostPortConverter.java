package com.kenshine.jcommander.demo03;

import com.beust.jcommander.IStringConverter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:44
 * @description： 自定义转换器
 * @modified By：
 * @version: $
 */
public class HostPortConverter implements IStringConverter<HostPort> {
    @Override
    public HostPort convert(String value) {
        String[] s = value.split(":");
        return new HostPort(s[0], Integer.parseInt(s[1]));
    }
}
