package com.kenshine.io.Test16_Sequence;

import org.junit.Test;

import java.io.*;
import java.util.Objects;
import java.util.Vector;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 20:30
 * @description：顺序流
 * @modified By：
 * @version: $
 *  SequenceInputStream可以将两个流合并
 *
 * 它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾；
 * 接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止
 */
public class SequenceInputStreamTest {

    /**
     * 两个流合并
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        FileInputStream fis1 = new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test16\\test01.txt");
        FileInputStream fis2 = new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test16\\test02.txt");
        SequenceInputStream seq= new SequenceInputStream(fis1,fis2);

        InputStreamReader isr = new InputStreamReader(seq);
        BufferedReader br = new BufferedReader(isr);

        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test16\\test03.txt"));

        String line = null;
        while((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        fis1.close();
        fis2.close();
        br.close();
        bw.close();
    }


    /**
     * 多个流合并
     * 将流放到Vector中
     */
    @Test
    public void test02_Multi() throws IOException {
        InputStream fis1 = new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test16\\test01.txt");
        InputStream fis2 = new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test16\\test02.txt");
        InputStream fis3 = new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test16\\test03.txt");

        Vector<InputStream> v = new Vector<>();
        v.addElement(fis1);
        v.addElement(fis2);
        v.addElement(fis3);

        SequenceInputStream sis = new SequenceInputStream(v.elements());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test16\\test04.txt"));

        byte[] buf = new byte[1024];
        int len = buf.length;
        while((len = sis.read(buf, 0, len)) != -1) {
            bos.write(buf, 0, len);
        }

        sis.close();
        bos.close();
    }

}
