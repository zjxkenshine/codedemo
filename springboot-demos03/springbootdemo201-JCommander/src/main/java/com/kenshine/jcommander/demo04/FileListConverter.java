package com.kenshine.jcommander.demo04;

import com.beust.jcommander.IStringConverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:53
 * @description：
 * @modified By：
 * @version: $
 */
public class FileListConverter implements IStringConverter<List<File>> {
    @Override
    public List<File> convert(String files) {
        String [] paths = files.split(",");
        List<File> fileList = new ArrayList<>();
        for(String path : paths){
            fileList.add(new File(path));
        }
        return fileList;
    }
}
