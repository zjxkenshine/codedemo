package com.kenshine.io.Test01_File;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 8:07
 * @description：文件字节流
 * @modified By：
 * @version: $
 * 1.写
 * 2.追加写
 * 3.文件字节输入流FileInputStream
 * 4.一次性读取多个字节
 * 5.字节流文件复制
 */
public class FileInputOutputStreamTest {

    /**
     * 1.写
     */
    @Test
    public void test01() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\fileoutput1.txt");
        //写一个 a
        fos.write(97);
        //写多个 ABCDE
        byte[] bytes={65,66,67,68,69};
        fos.write(bytes);
        //写入BCD
        fos.write(bytes,1,3);
        fos.close();
    }

    /**
     * 2.追加写
     * append 追加开关
     *      true:追加
     *      false:不追加
     * 换行：
     *     windows \r\n
     *     linux   /n
     *     mac     /r
     */
    @Test
    public void test02() throws IOException {
        //开启追加
        FileOutputStream fos=new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\fileoutput1.txt",true);
        //追加写
        for (int i = 0; i < 10; i++) {
            fos.write("kenshine".getBytes());
            fos.write("\r\n".getBytes());   //换行写
        }
        fos.close();
    }

    /**
     * 3.文件字节输入流FileInputStream
     */
    @Test
    public void test03() throws IOException {
        //创建FileInputStream对象，构造方法中绑定数据源
        FileInputStream fis=new FileInputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\fileoutput1.txt");
        //使用read读取一个字节并返回，读取到文件末尾返回-1
        //fis.read(); //默认一次仅读取一个字节
        //读取多个字节（多次读取，一次仅一字节）
        int len=0;//记录读取到的字节
        while ((len=fis.read())!=-1){
            System.out.println((char)len);
        }
        //释放资源
        fis.close();
    }

    /**
     * 4.一次读取多个字节数
     */
    @Test
    public void test04() throws IOException {
        FileInputStream fis=new FileInputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\fileoutput1.txt");
        //数组长度一般定义为1024(1kb)或者1024的倍数,越大一次性读取越多
        byte[] bytes=new byte[1024];
        int len;
        while((len=fis.read(bytes))!=-1){
            //仅读取有效的字符个数（去除byte数组后面的空值）
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
    }

    /**
     * 5.字节流文件复制
     */
    @Test
    public void test05() throws IOException {
        String from="D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\fileoutput1.txt";
        String to="D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\fileoutput2.txt";
        copy(from,to);
    }

    private void copy(String from,String to) throws IOException {
        //读取文件
        FileInputStream fis=new FileInputStream(from);
        //写入文件
        FileOutputStream fos=new FileOutputStream(to,true);
        //一次读取多个字节，写入多个字节
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=fis.read(bytes))!=-1){
            //使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
            fos.write(bytes,0,len);
        }
        //先关闭写，再关闭读
        fos.close();
        fis.close();
    }

}
