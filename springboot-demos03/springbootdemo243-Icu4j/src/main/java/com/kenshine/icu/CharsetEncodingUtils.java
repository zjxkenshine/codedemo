package com.kenshine.icu;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.*;
import java.nio.charset.UnsupportedCharsetException;

/**
 * @author by kenshine
 * @Classname CharsetEncodingUtils
 * @Description 获取文件编码
 * @Date 2023-05-20 10:30
 * @modified By：
 * @version: 1.0$
 */
public class CharsetEncodingUtils {
    public static String getCharset(InputStream in) throws IOException {
        String charset = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(in);
            CharsetDetector cd = new CharsetDetector();
            cd.setText(bis);
            CharsetMatch cm = cd.detect();
            if (cm != null) {
                charset = cm.getName();
            } else {
                throw new UnsupportedCharsetException("获取文件编码失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        }finally {
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != in) {
                in.close();
            }
        }

        return charset;
    }

    public static void main(String[] args) {
        File file = new File("D:\\Github\\codedemo\\springboot-demos03\\springbootdemo243-Icu4j\\pom.xml");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            String charset = getCharset(inputStream);
            System.out.println("charset:" + charset);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
