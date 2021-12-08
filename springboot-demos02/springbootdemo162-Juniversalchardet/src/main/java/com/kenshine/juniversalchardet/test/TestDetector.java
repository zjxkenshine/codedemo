package com.kenshine.juniversalchardet.test;

import org.mozilla.universalchardet.UniversalDetector;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 23:36
 * @description：简单示例
 * @modified By：
 * @version: $
 */
public class TestDetector {

    public static void main(String[] args) throws IOException {

        byte[] buf = new byte[4096];
        InputStream fis = Files.newInputStream(Paths.get("F:\\IDEAworkespace\\codedemo\\springboot-demos02\\springbootdemo162-Juniversalchardet\\src\\main\\resources\\test.txt"));

        // (1)
        UniversalDetector detector = new UniversalDetector();

        // (2)
        int nread;
        while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
            detector.handleData(buf, 0, nread);
        }
        // (3)
        detector.dataEnd();

        // (4)
        String encoding = detector.getDetectedCharset();
        if (encoding != null) {
            System.out.println("Detected encoding = " + encoding);
        } else {
            System.out.println("No encoding detected.");
        }

        // (5)
        detector.reset();
    }

}
