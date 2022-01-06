package com.kenshine.io.Test23_Gzip;

import org.junit.Test;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 22:37
 * @description：
 * @modified By：
 * @version: $
 */
public class GzipInputOutputStreamTest {

    /**
     * GzipInputOutputStream基本使用
     */
    @Test
    public void test() throws IOException {
        FileReader fr = new FileReader("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test23\\gzip.txt");
        BufferedReader in = new BufferedReader(fr);

        //starting to compress
        FileOutputStream fos = new FileOutputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test23\\gzip.gz");
        GZIPOutputStream gzipout = new GZIPOutputStream(fos);
        BufferedOutputStream bos = new BufferedOutputStream(gzipout);
        int c;
        while((c = in.read())!= -1){
            bos.write(c);
        }
        in.close();
        bos.close();

        //读取gzip文件
        FileInputStream fis = new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test23\\gzip.gz");
        GZIPInputStream gzipin = new GZIPInputStream(fis);
        InputStreamReader isr = new InputStreamReader(gzipin);
        BufferedReader in2 = new BufferedReader(isr);
        String s;
        while((s = in2.readLine())!= null){
            System.out.println(s);
        }
    }
}
