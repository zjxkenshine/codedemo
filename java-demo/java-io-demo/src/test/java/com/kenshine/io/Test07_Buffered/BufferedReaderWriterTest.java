package com.kenshine.io.Test07_Buffered;

import org.junit.Test;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 8:56
 * @description：缓冲字符流
 * @modified By：
 * @version: $
 *
 * 1.BufferedWriter 写入数据
 * 2.BufferedReader读取数据
 */
public class BufferedReaderWriterTest {

    /**
     * 1.BufferedWriter写入数据
     */
    @Test
    public void Test01() throws IOException {
        //1.创建BufferedWriter并传递FileWriter对象
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test07\\bufferedwriter.txt"));
        //2.调用字符缓冲输出流中的方法write,把数据写入到内存缓冲区中
        for (int i = 0; i <5 ; i++) {
            bw.write("BufferedWriter写入的数据");
            //写入一个行分隔符
            bw.newLine();
        }
        //3.刷新flush
        bw.flush();
        //4.释放资源
        bw.close();
    }

    /**
     * 2.BufferedReader读取数据
     */
    @Test
    public void test02() throws IOException{
        //1.创建缓冲流并传递
        BufferedReader br=new BufferedReader(new FileReader("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test07\\bufferedwriter.txt"));
        //2.使用read/readLine读取文本
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        //3.关闭
        br.close();
    }

}
