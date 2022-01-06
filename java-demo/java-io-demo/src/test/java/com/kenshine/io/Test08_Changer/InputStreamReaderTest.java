package com.kenshine.io.Test08_Changer;

import org.junit.Test;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 9:09
 * @description：转换流
 * @modified By：
 * @version: $
 * 编码：按照某种规则将字符存储到计算机中 字符——>字节（能看懂到看不懂）
 * 解码/译码：将存储在计算机的二进制数解析显示 字节——>字符（看不懂到能看懂）
 *
 * FileReader读取系统默认编码（ANSI=GBK）会产生乱码，只能指定默认编码表(UTF-8)
 * InputStreamReader：可指定编码表
 *
 * 1.InputStreamReader读取 GBK编码
 * 2.转换文件编码
 */
public class InputStreamReaderTest {

    /**
     * 1.InputStreamReader读取 GBK编码
     */
    @Test
    public void test01() throws IOException {
        //1.创建对象
        InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test08\\gbk.txt"),"gbk");
        //2.读取
        int len=0;
        while((len=isr.read())!=-1){
            System.out.println((char)len);
        }
        //3.关闭
        isr.close();
    }

    /**
     * 2.转换文件编码
     */
    @Test
    public void test02() throws IOException{
        //创建对象
        InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test08\\gbk.txt"),"gbk");
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test08\\utf-8.txt"));
        //读取并写入
        char[] chars=new char[20];
        int len=0;
        while((len=isr.read(chars))!=-1){
            osw.write(chars,0,len);
        }
        //关闭
        osw.close();
        isr.close();
    }

}
