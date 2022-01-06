package com.kenshine.io.Test10_Piped;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 9:42
 * @description：
 * @modified By：
 * @version: $
 *
 * 发送者线程
 */
public class Receiver extends Thread {
    // 管道输入流对象。
    // 它和“管道输出流(PipedWriter)”对象绑定，
    // 从而可以接收“管道输出流”的数据，再让用户读取。
    private PipedReader in = new PipedReader();

    // 获得“管道输入流对象”
    public PipedReader getReader(){
        return in;
    }

    @Override
    public void run(){
        //仅读取1024个字符
        //readMessageOnce() ;
        //可以读取多个缓冲区
        readMessageContinued() ;
    }

    // 从“管道输入流”中读取1次数据
    public void readMessageOnce(){
        // 虽然buf的大小是2048个字符，但最多只会从“管道输入流”中读取1024个字符。
        // 因为，“管道输入流”的缓冲区大小默认只有1024个字符。
        char[] buf = new char[2048];
        try {
            int len = in.read(buf);
            System.out.println(new String(buf,0,len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从“管道输入流”读取>1024个字符时，就停止读取
    public void readMessageContinued(){
        int total=0;
        while(true) {
            char[] buf = new char[1024];
            try {
                int len = in.read(buf);
                total += len;
                System.out.println(new String(buf,0,len));
                // 若读取的字符总数>1024，则退出循环。
                if (total > 1024)
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
