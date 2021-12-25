package com.kenshine.jcommander.demo04;

import com.beust.jcommander.Parameter;

import java.io.File;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:54
 * @description：
 * @modified By：
 * @version: $
 */
public class Args04 {
    @Parameter(names = "-files", listConverter = FileListConverter.class)
    List<File> file;
}
