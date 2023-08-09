package com.kenshin.telnet;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author by kenshine
 * @Classname TelnetUtil
 * @Description 客户端工具
 * @Date 2023-08-05 18:06
 * @modified By：
 * @version: 1.0$
 */
public class TelnetUtil {

    public static TelnetClient telnetClinet = null;
    public static InputStream is = null;
    public static OutputStream os = null;

    /**
     * 连接远程计算机,连接完成后，获取读取流与发送流
     *
     * @param ip   远程计算机IP地址
     * @param port 远程计算机端口
     */
    public static void connection(String ip, int port) {
        try {
            telnetClinet = new TelnetClient();
            telnetClinet.connect(ip, port);
            is = telnetClinet.getInputStream();
            os = telnetClinet.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取远程计算机返回的信息
     */
//    public static String readTelnetMsg() {
//        try {
//            StringBuilder line = new StringBuilder();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            while(reader.ready()) {
//                 line.append("\n").append(reader.readLine());
//            }
//            System.out.println(line.toString());
//            return line.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    /**
     * 获取远程计算机返回的信息
     * */
    public static String readTelnetMsg() {
        try {
            int len = 0;
            byte[] b = new byte[1024];
            len = is.read(b);
            if (len >= 0)
                return new String(b, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 向远端计算机发送指令消息
     * @param msg 需要传送的指令
     **/
    public static void sendTelnetMsg(String msg) {
        byte[] b = msg.getBytes(StandardCharsets.UTF_8);
        try {
            os.write(b);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找远端计算机返回的指令中是否包含想要指令
     * 一直查找，直到包含，返回true
     */
    public static boolean findStr(String str) {
        for (; ; ) {
            String msg = readTelnetMsg();
            System.out.println(msg);
            if (msg.indexOf(str) != -1)
                return true;
        }
    }

    /**
     * 关闭连接，关闭IO
     */
    public static void close() {
        try {
            is.close();
            os.close();
            telnetClinet.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
