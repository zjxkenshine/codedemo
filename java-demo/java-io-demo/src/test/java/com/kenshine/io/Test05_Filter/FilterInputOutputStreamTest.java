package com.kenshine.io.Test05_Filter;

import org.junit.Test;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 23:14
 * @description：
 * @modified By：
 * @version: $
 * FilterInputStream/FilterOutputStream 为基础流提供一些额外的功能..
 * 1. DataInputStream.数据输入流, 以机器无关的方式读取Java的基本类型
 * 2. BufferedInputStream缓冲输入流, 由于基础输入流一个字节一个字节读取,频繁与磁盘进行交互,造成读取速度较低.缓冲流的存在就是先将数据读取到缓冲流(内存中),然后一次性从内存中读取多个字符.提高读取的效率
 * 3. PushBackInputStream回退输入流, java中读取数据的方式是顺序读取,如果某个数据不需要读取,需要程序处理.PushBackInputStream就可以将某些不需要的数据回退到缓冲中
 *
 */
public class FilterInputOutputStreamTest {

    /**
     * DataInputStream/DataOutputStream 数据流
     */
    @Test
    public void test01() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test05\\test05.txt"));
        dos.writeInt(1234567);
        DataInputStream dis = new DataInputStream(new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test05\\test05.txt"));
        System.out.println(dis.readInt());
        dis.close();
        dos.close();
    }

    /**
     * BufferedInputStream/BufferedOutputStream 缓冲流
     */
    @Test
    public void test02() throws IOException {
        File src = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test05\\test05.txt");
        File target = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test05\\aaa.txt");
        copyFileByBuffer(src, target);
    }



    /**
     * 拷贝文件：将src复制到target
     */
    private void copyFileByBuffer(File src, File target) throws IOException {
        if (!src.exists()) {
            return;
        }
        if (!target.exists()) {
            target.createNewFile();
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        // 优先使用高级流，速度快
        fis = new FileInputStream(src);
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream(target);
        bos = new BufferedOutputStream(fos);
        byte[] buf = new byte[1024];
        int lenth = -1;
        lenth = bis.read(buf);// 读
        while (lenth != -1) {
            bos.write(buf, 0, lenth);// 写
            lenth = bis.read(buf);// 读
        }
        // 先关高级流
        // 实际上关闭高级流的同时，低级流也会被关掉了
        bis.close();
        bos.close();
        fis.close();
        fos.close();
    }

}
