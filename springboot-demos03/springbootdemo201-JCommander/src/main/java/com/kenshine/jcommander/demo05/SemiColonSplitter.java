package com.kenshine.jcommander.demo05;

import com.beust.jcommander.converters.IParameterSplitter;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:56
 * @description：自定拆分其
 * @modified By：
 * @version: $
 */
public class SemiColonSplitter implements IParameterSplitter {
    @Override
    public List<String> split(String value) {
        // 会拆分file1;file2;file3为 file1, file2，file3
        return Arrays.asList(value.split(";"));
    }
}
