package com.kenshine.io.Test07_Buffered;

import org.junit.Test;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 8:56
 * @description：缓存字节流
 * @modified By：
 * @version: $
 * 一次读取多个字节，和read(byte[])差不多
 * 缓冲流配合read(byte[])使用速度最快
 *
 * 1.BufferedOutputStream写入数据
 * 2.BufferedInputStream读取数据
 */
public class BufferedInputOutputStreamTest {

    /**
     * 1.BufferedOutputStream基本使用
     */
    @Test
    public void test01() throws IOException {
        //1.创建FileOutputStream对象，构造方法中绑定输出目的地
        FileOutputStream fos=new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test07\\bufferedout");
        //2.创建BufferedOutputStream对象
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        //3.使用bos的write写入数据到内部缓冲区
        bos.write("缓冲流写入数据".getBytes());
        //4.刷新(可省略)
        bos.flush();
        //5.关闭(仅关闭缓冲流即可)
        bos.close();
    }

    /**
     * 2.BufferedInputStream读取数据
     */
    @Test
    public void test02() throws IOException {
        //1.创建FileInputStream对象
        FileInputStream fis=new FileInputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test07\\bufferedout");
        //2.创建BufferedInputStream对象
        BufferedInputStream bis=new BufferedInputStream(fis);
        //3.read读取文件
        byte[] bytes=new byte[1024];    //每次读取1024字节
        int len=0;//记录每次读取到的字节/个数
        while((len=bis.read(bytes))!=-1){
            //System.out.println(len);
            System.out.println(new String(bytes,0,len));
        }
        //4.释放资源(仅关闭缓冲流即可)
        bis.close();
    }


}
