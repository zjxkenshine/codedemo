package com.kenshine.basic._10_Network;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 12:48
 * @description：
 * @modified By：
 * @version: $
 *
 * 使用java.net的URL类获取URL的各个部分参数
 *
 *
 * URL：统一资源定位符； URI：统一资源标识符
 * Java中URI类唯一作用就是解析，而URL可以打开一个到达资源的流
 */
public class Test01_URL {

    @Test
    public void test01(){
        try {
            URL url = new URL("http://www.runoob.com/index.html?language=cn#j2se");
            System.out.println("URL 为：" + url.toString());
            System.out.println("协议为：" + url.getProtocol());
            System.out.println("验证信息：" + url.getAuthority());
            System.out.println("文件名及请求参数：" + url.getFile());
            System.out.println("主机名：" + url.getHost());
            System.out.println("路径：" + url.getPath());
            System.out.println("端口：" + url.getPort());
            System.out.println("默认端口：" + url.getDefaultPort());
            System.out.println("请求参数：" + url.getQuery());
            System.out.println("定位位置：" + url.getRef());
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * URI/统一资源标识符
     */
    @Test
    public void test02(){
        try {
            URI uri = new URI("http://www.runoob.com/index.html?language=cn#j2se");
            System.out.println("URI 为：" + uri.toString());
            System.out.println("验证信息：" + uri.getAuthority());
            System.out.println("主机名：" + uri.getHost());
            System.out.println("路径：" + uri.getPath());
            System.out.println("端口：" + uri.getPort());
            System.out.println("请求参数：" + uri.getQuery());
        }catch(URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
