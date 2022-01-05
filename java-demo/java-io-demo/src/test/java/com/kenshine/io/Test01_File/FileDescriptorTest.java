package com.kenshine.io.Test01_File;

import org.junit.Test;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 21:44
 * @description： FileDescriptor 文件描述符
 * @modified By：
 * @version: $
 *
 * FileDescriptor 文件描述符，可以被用来表示开放文件、开放套接字等
 * 但是，我们不能直接通过FileDescriptor对该文件进行操作；
 * 若需要通过FileDescriptor对该文件进行操作，则需要新创建FileDescriptor对应的FileOutputStream，再对文件进行操作
 *
 * (1) in -- 标准输入(键盘)的描述符
 * (2) out -- 标准输出(屏幕)的描述符
 * (3) err -- 标准错误输出(屏幕)的描述符
 */
public class FileDescriptorTest {


    @Test
    public void test01(){
        try {
            FileOutputStream out = new FileOutputStream(FileDescriptor.out);
            //相当于system.out.println
            out.write('A');
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String FileName = "file.txt";
    private static final String OutText = "Hi FileDescriptor";

    /**
     * FileDescriptor.out 的测试程序
     * 该程序的效果 等价于 System.out.println(OutText);
     */
    @Test
    public void testStandFD() {
        // 创建FileDescriptor.out 对应的PrintStream
        PrintStream out = new PrintStream(
                new FileOutputStream(FileDescriptor.out));
        // 在屏幕上输出“Hi FileDescriptor”
        out.println(OutText);
        out.close();
    }

    /**
     * FileDescriptor写入示例程序
     * (1) 为了说明，"通过文件名创建FileOutputStream"与“通过文件描述符创建FileOutputStream”对象是等效的
     * (2) 该程序会在“该源文件”所在目录新建文件"file.txt"，并且文件内容是"Aa"。
     */
    @Test
    public void testWrite() {
        try {
            // 新建文件“file.txt”对应的FileOutputStream对象
            FileOutputStream out1 = new FileOutputStream(FileName);
            // 获取文件“file.txt”对应的“文件描述符”
            FileDescriptor fdout = out1.getFD();
            // 根据“文件描述符”创建“FileOutputStream”对象
            FileOutputStream out2 = new FileOutputStream(fdout);

            out1.write('A');  // 通过out1向“file.txt”中写入'A'
            out2.write('a');  // 通过out2向“file.txt”中写入'A'

            if (fdout!=null)
                System.out.printf("fdout(%s) is %s\n",fdout, fdout.valid());

            out1.close();
            out2.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileDescriptor读取示例程序
     * 为了说明，"通过文件名创建FileInputStream"与“通过文件描述符创建FileInputStream”对象是等效的
     */
    @Test
    public void testRead() {
        try {
            // 新建文件“file.txt”对应的FileInputStream对象
            FileInputStream in1 = new FileInputStream(FileName);
            // 获取文件“file.txt”对应的“文件描述符”
            FileDescriptor fdin = in1.getFD();
            // 根据“文件描述符”创建“FileInputStream”对象
            FileInputStream in2 = new FileInputStream(fdin);

            System.out.println("in1.read():"+(char)in1.read());
            System.out.println("in2.read():"+(char)in2.read());

            if (fdin!=null)
                System.out.printf("fdin(%s) is %s\n", fdin, fdin.valid());

            in1.close();
            in2.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}
