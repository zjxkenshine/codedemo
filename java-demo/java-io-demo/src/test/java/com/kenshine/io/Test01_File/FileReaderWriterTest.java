package com.kenshine.io.Test01_File;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 8:08
 * @description：文件字符流
 * @modified By：
 * @version: $
 *
 * 1.FileWriter 字符流写
 * 2.FileReader字符流读取
 */
public class FileReaderWriterTest {

    /**
     * 1.FileWriter 字符流写
     */
    @Test
    public void test01() throws IOException{
        FileWriter fw=new FileWriter("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\filewriter.txt");
        fw.write("哈哈哈哈哈啊哈哈");
        //把内存中数据刷新到文件中
        fw.flush();
        fw.write("kenshine 是个废物");
        //close也会刷新到文件
        fw.close();
    }

    /**续写：两个参数的构造方法
     * FileWriter(File file,boolean append);
     * FileReader(String path,boolean append);
     *换行：
     *  windows \r\n
     *  linux /n
     *  mac /r
     */
    @Test
    public void test02() throws IOException{
        FileWriter fw=new FileWriter("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\filewriter.txt",true);
        fw.write("这是续写的字符串");
        //把内存中数据刷新到文件中
        fw.flush();
        fw.write("fjnioewgjiwaofa\r\n");
        //close也会刷新到文件
        fw.close();
    }

    /**
     * 3.FileReader字符流读取
     */
    @Test
    public void test03() throws IOException {
        //创建FileReader对象，绑定数据源
        FileReader fr=new FileReader("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\filewriter.txt");
        //使用FileReader对象的Read读字符(需要为UTF8编码)
        int len=0;
        while ((len=fr.read())!=-1){
            System.out.print((char)len);    //一次读取一个
        }

        //读取完需要重新绑定数据源(指针已经到文件末尾)
        fr=new FileReader("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\filewriter.txt");
        //存储读取到的多个字符
        char[] cs=new char[1024];
        int len1=0;
        while ((len1=fr.read(cs))!=-1){
            //一次读取多个
            System.out.print(new String(cs,0,len1));
        }

        //关闭字符流,释放资源
        fr.close();
    }


}
