package com.kenshine.jcommander.demo02;

import com.beust.jcommander.Parameter;

import java.io.File;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:39
 * @description：
 * @modified By：
 * @version: $
 */
public class Args02 {
    /**
     * file转换器
     */
    @Parameter(names = "-file", converter = FileConverter.class)
    File file;

    /**
     * 多个
     */
    @Parameter(names = "-files", converter = FileConverter.class)
    List<File> files;
}
