package com.kenshine.io.Test08_Changer;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 9:09
 * @description：OutputStreamWriter 写入转换流
 * @modified By：
 * @version: $
 * OutputStreamWriter 写入
 */
public class OutputStreamWriterTest {
    /**
     * 1.OutputStreamWriter写入
     */
    @Test
    public void test01() throws IOException {
        //1.创建OutputStreamWriter对象
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test08\\gbk.txt",true),"gbk");
        //2.使用Write
        osw.write("你好,这是GBK编码的文件");
        //3.使用flush
        osw.flush();
        //4.释放资源
        osw.close();
    }
}
