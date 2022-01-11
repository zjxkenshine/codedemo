package com.kenshine.basic._10_Network;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 13:13
 * @description：
 * @modified By：
 * @version: $
 * 用于处理HTTP类型的URL连接
 *
 * 1.通过调用URL.openConnection()来获得一个新的HttpURLConnection对象，并且将其结果强制转换为HttpURLConnection.
 * 2.准备请求。一个请求主要的参数是它的URI。请求头可能也包含元数据，例如证书，首选数据类型和会话cookies.
 * 3.可以选择性的上传一个请求体。HttpURLConnection实例必须设置setDoOutput(true)，如果它包含一个请求体。通过将数据写入一个由getOutStream()返回的输出流来传输数据。
 * 4.读取响应。响应头通常包含元数据例如响应体的内容类型和长度，修改日期和会话cookies。响应体可以被由getInputStream返回的输入流读取。如果响应没有响应体，则该方法会返回一个空的流。
 * 5.关闭连接。一旦一个响应体已经被阅读后，HttpURLConnection 对象应该通过调用disconnect()关闭。断开连接会释放被一个connection占有的资源，这样它们就能被关闭或再次使用。
 *
 */
public class Test03_HttpURLConnection {

    //Get请求
    @Test
    public void test01(){
        String message="";
        try {
            URL url=new URL("http://www.baidu.com");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5*1000);
            connection.connect();
            InputStream inputStream=connection.getInputStream();
            byte[] data=new byte[1024];
            StringBuffer sb=new StringBuffer();
            int length=0;
            while ((length=inputStream.read(data))!=-1){
                String s=new String(data, StandardCharsets.UTF_8);
                sb.append(s);
            }
            message=sb.toString();
            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }

    /**
     * Post请求
     */
    @Test
    public void test02(){
        String message="";
        try {
            URL url=new URL("http://119.29.175.247/wikewechat/Admin/Login/login.html");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            connection.setRequestProperty("Content-type","application/x-javascript->json");
            connection.connect();
            OutputStream outputStream=connection.getOutputStream();
            StringBuffer sb=new StringBuffer();
            sb.append("email=");
            sb.append("409947972@qq.com&");
            sb.append("password=");
            sb.append("1234&");
            sb.append("verify_code=");
            sb.append("4fJ8");
            String param=sb.toString();
            outputStream.write(param.getBytes());
            outputStream.flush();
            outputStream.close();
            System.out.println("responseCode"+connection.getResponseCode());
            InputStream inputStream=connection.getInputStream();
            byte[] data=new byte[1024];
            StringBuffer sb1=new StringBuffer();
            int length=0;
            while ((length=inputStream.read(data))!=-1){
                String s=new String(data, StandardCharsets.UTF_8);
                sb1.append(s);
            }
            message=sb1.toString();
            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }

}
