package com.kenshine.brother;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author kenshine
 */
public class TcpClient implements Runnable{
    @Override
    public void run() {
        String host="192.168.20.75";
        Socket s1=  new Socket();
        try {
            //创建一个socket绑定的端口和地址 本机。设置超时1000毫秒
            s1.connect(new InetSocketAddress(host, 10000), 1000);
            s1.close();
            Socket s = new Socket(host, 10000);
            s.setSoTimeout(1000);
            //获取到输出流
            OutputStream oos = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oos));
            String line= "%CLOD    PRD3      \r\nLFss%";
            bw.write(line);
            bw.flush();
            if (s.isConnected()){
                System.out.println("brother连接成功");
            }
            //获取到输入流
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line1;
            int i = 0;
            String data = "";
            while (!(line = br.readLine()).equals("")){
                line1 = br.readLine();
                System.out.print(i + ":");
                System.out.println(line1);
                if (i == 2){
                    data = line1;
                    String data1[] = data.split(",");
                    System.out.println(data1.length);
                }
                i++;
                break;
            }
            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(oos));
            bw1.write(line);
            bw1.flush();
            if (s.isConnected()){
                System.out.println("brother连接成功");
            }
            //获取到输入流
            InputStream is1 = s.getInputStream();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
            String line2;
            int i1 = 0;
            String data1 = "";
            while (!(line = br.readLine()).equals("")){
                line2 = br1.readLine();
                System.out.print(i1 + ":");
                System.out.println(line2);
                if (i1 == 2){
                    data1 = line2;
                    String data2[] = data1.split(",");
                    System.out.println(data2.length);
                }
                i1++;
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                s1.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //在开启发送端的线程
        new Thread(new TcpClient()).start();
    }
}