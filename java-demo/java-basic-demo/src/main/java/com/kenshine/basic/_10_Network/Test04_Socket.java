package com.kenshine.basic._10_Network;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 18:52
 * @description：
 * @modified By：
 * @version: $
 * ServerSocket 服务端
 * Socket 客户端
 *
 * 简单示例一
 */
public class Test04_Socket {

    /**
     * ServerSocket
     */
    @Test
    public void test01_Server() throws IOException {
        // 端口号
        int port = 7000;
        // 在端口上创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(port);
        // 监听来自客户端的连接
        Socket socket = serverSocket.accept();

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        do {
            double length = dis.readDouble();
            System.out.println("服务器端收到的边长数据为：" + length);
            double result = length * length;
            dos.writeDouble(result);
            dos.flush();
        } while (dis.readInt() != 0);
        socket.close();
        serverSocket.close();
    }

    /**
     * Client
     */
    @Test
    public void test02_Client() throws IOException {
        int port = 7000;
        String host = "localhost";

        // 创建一个套接字并将其连接到指定端口号
        Socket socket = new Socket(host, port);

        //从socket中获取输入流
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        //从socket中获取输出流
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            System.out.println("请输入正方形的边长:");
            double length = sc.nextDouble();
            dos.writeDouble(length);
            dos.flush();
            double area = dis.readDouble();
            System.out.println("服务器返回的计算面积为:" + area);
            while (true) {
                System.out.println("继续计算？(Y/N)");
                String str = sc.next();
                if (str.equalsIgnoreCase("N")) {
                    dos.writeInt(0);
                    dos.flush();
                    flag = true;
                    break;
                } else if (str.equalsIgnoreCase("Y")) {
                    dos.writeInt(1);
                    dos.flush();
                    break;
                }
            }
        }
        socket.close();
    }

    /**
     * 一个服务，多个客户端
     */
    @Test
    public void test03() throws IOException {
        int port = 7000;
        int clientNo = 1;

        ServerSocket serverSocket = new ServerSocket(port);
        // 创建线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                exec.execute(new SingleServer(socket, clientNo));
                clientNo++;
            }
        } finally {
            serverSocket.close();
        }
    }

}

//单个客户端
class SingleServer implements Runnable {
    private Socket socket;
    private int clientNo;

    public SingleServer(Socket socket, int clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            do {
                double length = dis.readDouble();
                System.out.println("从客户端" + clientNo + "接收到的边长数据为：" + length);
                double result = length * length;
                dos.writeDouble(result);
                dos.flush();
            } while (dis.readInt() != 0);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("与客户端" + clientNo + "通信结束");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}