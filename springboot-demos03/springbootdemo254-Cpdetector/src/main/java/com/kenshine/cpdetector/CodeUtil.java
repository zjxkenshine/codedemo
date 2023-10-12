package com.kenshine.cpdetector;

import info.monitorenter.cpdetector.io.*;

import java.io.File;

/**
 * @author by kenshine
 * @Classname CodeUtil
 * @Description 获取文件编码
 * @Date 2023-10-12 11:14
 * @modified By：
 * @version: 1.0$
 */
public class CodeUtil {
    public static String getFileEncode(String filePath) {
        String charsetName = null;
        try {
            File file = new File(filePath);
            CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
            detector.add(new ParsingDetector(false));
            detector.add(JChardetFacade.getInstance());
            detector.add(ASCIIDetector.getInstance());
            detector.add(UnicodeDetector.getInstance());
            java.nio.charset.Charset charset = null;
            charset = detector.detectCodepage(file.toURI().toURL());
            if (charset != null) {
                charsetName = charset.name();
            } else {
                charsetName = "UTF-8";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return charsetName;
    }

    public static void main(String[] args) {
        System.out.println(getFileEncode("E:\\test\\666.txt"));
    }

}
