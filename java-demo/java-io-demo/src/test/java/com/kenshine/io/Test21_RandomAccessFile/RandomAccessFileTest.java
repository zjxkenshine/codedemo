package com.kenshine.io.Test21_RandomAccessFile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 21:51
 * @description：
 * @modified By：
 * @version: $
 *
 * RandomAccessFile既可以读取文件内容，也可以向文件输出数据。
 * 同时，RandomAccessFile支持“随机访问”的方式，程序快可以直接跳转到文件的任意地方来读写数据
 *
 *
 * 与OutputStream、Writer等输出流不同的是，RandomAccessFile允许自由定义文件记录指针，RandomAccessFile可以不从开始的地方开始输出，
 * 因此RandomAccessFile可以向已存在的文件后追加内容。如果程序需要向已存在的文件后追加内容，则应该使用RandomAccessFile
 *
 * 底层实现中他实现的是DataInput和DataOutput接口，并非是FileInputStream和FileOutputStream
 *
 * 两个特殊方法：
 * long getFilePointer( )：返回文件记录指针的当前位置
 * void seek(long pos )：将文件指针定位到pos位置
 *
 * 有四种模式
    r	以只读的方式打开文本，也就意味着不能用write来操作文件
    rw	读操作和写操作都是允许的
    rws	每当进行写操作，同步的刷新到磁盘，刷新内容和元数据
    rwd	每当进行写操作，同步的刷新到磁盘，刷新内容

  使用场景：主要得益于seek可以控制光标
    大型文本日志类文件的快速定位获取数据
    并发读写
    更方便的获取二进制文件
 */
public class RandomAccessFileTest {

    /**
     * 1.基本使用
     */
    @Test
    public void test01(){
        String[] args = new String[]{"F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test20\\test20.txt"};
        if (args == null || args.length == 0) {
            throw new RuntimeException("请输入路径");
        }
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(args[0], "r");
            System.out.println("RandomAccessFile的文件指针初始位置:" + raf.getFilePointer());
            raf.seek(100);
            byte[] bbuf = new byte[1024];
            int hasRead = 0;
            while ((hasRead = raf.read(bbuf)) > 0) {
                System.out.print(new String(bbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试2 seek
     */
    @Test
    public void test02() throws IOException {
        RandomAccessFile raf = RAFTestFactory.getRAFWithModelR();
        System.out.println("raf.length()->获取文本内容长度:"+raf.length());
        System.out.println("raf.getFilePointer()->获取文本头指针:"+raf.getFilePointer());
        raf.seek(4);
        System.out.println("raf.getFilePointer()->第二次获取文本头指针:"+raf.getFilePointer());
    }

    /**
     * 写 拒绝访问
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        //只读
        RandomAccessFile raf = RAFTestFactory.getRAFWithModelR();
        raf.write(1);
    }

    /**
     * 写入数据
     */
    @Test
    public void test04() throws IOException {
        RandomAccessFile raf = RAFTestFactory.getRAFWithModelRW();
        String word = "kenshine";
        raf.write(word.getBytes());
    }

    /**
     * 实现插入操作
     */
    @Test
    public void test05() throws IOException {
        RandomAccessFile raf = RAFTestFactory.getRAFWithModelRW();
        raf.seek(4);
        String word = "kenshine";
        raf.write(word.getBytes());
    }

    @Test
    public void test06() throws IOException {
        RandomAccessFile raf = RAFTestFactory.getRAFWithModelRW();
        raf.writeByte(3);
        raf.writeChar('a');
        raf.writeShort(5);
        raf.writeInt(6);
        raf.writeLong(792929347162343l);
        raf.writeFloat(8.5f);
        raf.writeDouble(9.44d);
        raf.writeBoolean(true);
    }





}
