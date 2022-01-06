package com.kenshine.io.Test12_ByteArray;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 10:07
 * @description：字节数组 重点
 * @modified By：
 * @version: $
 * ByteArrayOutputStream 字节数组输出流在内存中创建一个字节数组缓冲区(默认大小32字节)，所有发送到输出流的数据保存在该字节数组缓冲区中
 * - 与FileOutputStream区别 ByteArrayOutputStream是保存在内存中，FileOutputStream是保存在文件中
 *
 * 使用场景：临时文件(内存虚拟文件或者内存映像文件),如传入一个文件返回一个压缩文件时可以使用
 *
 */
public class ByteArrayInputOutputStreamTest {
    private static final int LEN = 5;
    // 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
    private static final byte[] ArrayLetters = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    /**
     * 1.ByteArrayOutputStream写入数据
     */
    @Test
    public void testByteArrayOutputStream(){
        // 创建ByteArrayOutputStream字节流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 依次写入“A”、“B”、“C”三个字母。0x41对应A，0x42对应B，0x43对应C。
        baos.write(0x41);
        baos.write(0x42);
        baos.write(0x43);
        System.out.printf("baos=%s\n", baos);
        // 将ArrayLetters数组中从“3”开始的后5个字节写入到baos中。
        // 即对应写入“0x64, 0x65, 0x66, 0x67, 0x68”，即“defgh”
        baos.write(ArrayLetters, 3, 5);
        System.out.printf("baos=%s\n", baos);
        // 计算长度
        int size = baos.size();
        System.out.printf("size=%s\n", size);
        // 转换成byte[]数组
        byte[] buf = baos.toByteArray();
        String str = new String(buf);
        System.out.printf("str=%s\n", str);
        // 将baos写入到另一个输出流中
        try {
            //写入到另一个流
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            baos.writeTo(baos2);
            System.out.printf("baos2=%s\n", baos2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例二
     */
    @Test
    public void test02(){
        String str = "HELLOWORLD" ;		// 定义一个字符串，全部由大写字母组成
        ByteArrayInputStream bis = null ;	// 内存输入流
        ByteArrayOutputStream bos = null ;	// 内存输出流
        bis = new ByteArrayInputStream(str.getBytes()) ;	// 向内存中输入内容
        bos = new ByteArrayOutputStream() ;	// 准备从内存ByteArrayInputStream中读取内容
        int temp = 0 ;
        while((temp=bis.read())!=-1){
            char c = (char) temp ;	// 读取的数字变为字符
            bos.write(Character.toLowerCase(c)) ;	// 将字符变为小写
        }
        // 所有的数据就全部都在ByteArrayOutputStream中
        String newStr = bos.toString() ;	// 取出内容
        try{
            bis.close() ;
            bos.close() ;
        }catch(IOException e){
            e.printStackTrace() ;
        }
        System.out.println(newStr) ;
    }

}
