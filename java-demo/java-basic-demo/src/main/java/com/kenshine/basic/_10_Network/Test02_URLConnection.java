package com.kenshine.basic._10_Network;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.runner.JUnitCore.main;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 12:51
 * @description：
 * @modified By：
 * @version: $
 *
 * URLConnection是一个抽象类，表示指向URL指定资源的活动连接
 *
 * 直接使用URLConnection类的程序遵循以下基本步骤：
 * 构造一个URL对象；
 * 调用这个URL对象的openConnection()获取一个对应该URL的URLConnection对象；
 * 配置这个URLConnection；
 * 读取首部字段；
 * 获得输入流并读取数据；
 * 获得输出流并写入数据；
 * 关闭连接；
 *
 * 下面是使用URLConnection对象从一个URL获取数据所需的最起码的步骤：
 * 构造一个URL对象；
 * 调用这个URL对象的openConnection()方法，获取对应该该URL的URLConnection对象；
 * 调用这个URLConnection的getInputStream()方法；
 * 使用通常的流API读取输入流；
 *
 * URL和URLConnection这两个类最大的不同在于：
 * URLConnection提供了对HTTP首部的访问；
 * URLConnection可以配置发送给服务器的请求参数；
 * URLConnection除了读取服务器数据外，还可以向服务器写入数据；
 *
 */
public class Test02_URLConnection {

    /**
     * 读取指定的首部字段
     */
    @Test
    public void test01(){
        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection connection = url.openConnection();
            System.out.println("Content-Type: " + connection.getContentType());
            System.out.println("Content-Length: " + connection.getContentLength());
            System.out.println("Content-LengthLong: " + connection.getContentLengthLong());
            System.out.println("Content-encoding: " + connection.getContentEncoding());
            System.out.println("Date: " + connection.getDate());
            System.out.println("Expires: " + connection.getExpiration());
            System.out.println("Last-modified: " + connection.getLastModified());
        } catch (IOException e) {
        }
    }

    /**
     * 获取任意首部字段
     * getHeaderField
     */
    @Test
    public void test02() throws IOException {
        URL url = new URL("http://www.baidu.com");
        URLConnection connection = url.openConnection();
        System.out.println(connection.getHeaderField("Content-Type"));
        System.out.println(connection.getHeaderField("last-modified"));

        //循环整个请求头信息
        for (int i = 1; ; i++) {
            String header = connection.getHeaderField(i);
            if (header == null) {
                break;
            }
            System.out.println(connection.getHeaderFieldKey(i)+": "+header);
        }
    }

    /**
     * 向服务器写入数据
     * 使用POST向Web服务器提交表单，或者使用PUT上传文件
     *
     */
    @Test
    public void test03(){
        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            OutputStream buff = new BufferedOutputStream(out);
            OutputStreamWriter writer = new OutputStreamWriter(buff);
            //向服务器写入数据
            writer.write("name=yd&sex=man");
            writer.flush();
            writer.close();
            System.out.println(connection.getContent());
        } catch (IOException e) {
        }
    }

}
