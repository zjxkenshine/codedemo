package com.kenshine.io.Test22_Inflater_Deflater;

import org.junit.Test;

import java.io.*;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 22:18
 * @description：Deflate/Inflater压缩流
 * @modified By：
 * @version: $
 * InflaterInputStream 解压数据
 * InflaterOutputStream 解压数据
 * DeflaterInputStream 实现输入流过滤器，以“deflate”压缩格式压缩数据
 * DeflaterOutputStream  输出流过滤器，用于以“deflate”压缩格式压缩数据
 *
 */
public class InflaterInputOutputStreamTest {

    /**
     * DeflaterOutputStream 压缩数据
     */
    @Test
    public void test_Deflate() throws IOException {
        OutputStream out=new FileOutputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test22\\test.txt");
        Deflater d = new Deflater();
        DeflaterOutputStream dout = new DeflaterOutputStream(out, d);
        dout.write("kenshine 555555555".getBytes());
        dout.close();
    }

    /**
     * InflaterInputStream 解压数据
     */
    @Test
    public void test_Inflate() throws IOException {
        InputStream in=new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test22\\test.txt");
        InflaterInputStream ini = new InflaterInputStream(in);
        ByteArrayOutputStream bout =new ByteArrayOutputStream(512);
        int b;
        while ((b = ini.read()) != -1) {
            bout.write(b);
        }
        ini.close();
        bout.close();
        String s=new String(bout.toByteArray());
        System.out.print(s);
    }



}
