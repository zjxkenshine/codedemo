package com.kenshine.juniversalchardet.test;

import org.mozilla.universalchardet.ReaderFactory;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 23:46
 * @description： 测试三，阅读器测试
 * @modified By：
 * @version: $
 */
public class TestCreateReaderFromFile {
    public static void main(String[] args) throws IOException {
        //模拟输入文件名
        args = new String[]{"F:\\IDEAworkespace\\codedemo\\springboot-demos02\\springbootdemo162-Juniversalchardet\\src\\main\\resources\\test.txt"};

        if (args.length != 1) {
            System.err.println("Usage: java TestCreateReaderFromFile FILENAME");
            System.exit(1);
        }

        Reader reader = null;
        try {
            File file = new File(args[0]);
            reader = ReaderFactory.createBufferedReader(file);

            // Do whatever you want with the reader
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
