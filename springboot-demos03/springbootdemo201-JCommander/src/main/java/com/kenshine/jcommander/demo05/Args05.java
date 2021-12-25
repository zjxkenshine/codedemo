package com.kenshine.jcommander.demo05;

import com.beust.jcommander.Parameter;
import com.kenshine.jcommander.demo02.FileConverter;

import java.io.File;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:57
 * @description：
 * @modified By：
 * @version: $
 */
public class Args05 {
    @Parameter(names = "-files", converter = FileConverter.class, splitter = SemiColonSplitter.class)
    List<File> files;
}
