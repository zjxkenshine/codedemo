package com.kenshine.juniversalchardet.test;

import org.mozilla.universalchardet.UniversalDetector;

import java.io.File;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 23:42
 * @description：检测文件的编码
 * @modified By：
 * @version: $
 */
public class TestDetectorFile {

    public static void main(String[] args) throws IOException {
        //模拟输入文件名
        args = new String[]{"F:\\IDEAworkespace\\codedemo\\springboot-demos02\\springbootdemo162-Juniversalchardet\\src\\main\\resources\\test.txt"};

        if (args.length != 1) {
            System.err.println("Usage: java TestDetectorFile FILENAME");
            System.exit(1);
        }
        File file = new File(args[0]);
        String encoding = UniversalDetector.detectCharset(file);
        if (encoding != null) {
            System.out.println("Detected encoding = " + encoding);
        } else {
            System.out.println("No encoding detected.");
        }
    }
}
