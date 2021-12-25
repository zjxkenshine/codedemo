package com.kenshine.jcommander.demo02;

import com.beust.jcommander.IStringConverter;

import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:39
 * @description：文件类型转换器
 * @modified By：
 * @version: $
 */
public class FileConverter implements IStringConverter<File> {
    @Override
    public File convert(String value) {
        return new File(value);
    }
}
