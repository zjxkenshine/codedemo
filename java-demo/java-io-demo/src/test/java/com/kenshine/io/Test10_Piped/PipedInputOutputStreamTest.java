package com.kenshine.io.Test10_Piped;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 9:24
 * @description：管道字节流
 * @modified By：
 * @version: $
 *
 * Java里的管道输入流PipedInputStream与管道输出流PipedOutputStream实现了类似管道的功能，用于不同线程之间的相互通信
 * 不要在一个线程中同时使用PipeInputStream和PipeOutputStream，这会造成死锁
 * 线程A(写) ——>PipeInputStream ——> 管道connect ——> PipeOutputStream ——>线程B(读)
 */
public class PipedInputOutputStreamTest {

    /**
     * 管道流使用示例
     */
    @Test
    public void test01(){
        try(PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream();) {

            //链接
            pis.connect(pos);
            //写线程
            InThread it = new InThread(pos,pis);
            //读线程
            OutThread ot = new OutThread(pos,pis);
            it.start();
            ot.start();
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    //写线程（管道输入线程，生产者）
    class InThread extends Thread{
        PipedOutputStream pos = null;
        PipedInputStream pis = null ;
        InThread(PipedOutputStream pos,PipedInputStream pis ){
            this.pos = pos;
            this.pis = pis;
        }
        public void run() {
            try {
                //写入数据
                byte[] b = "管道流测试 !".getBytes();
                pos.write(b);
                //关闭链接，此处必须关闭，不然会包异常
                pos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //读线程（管道输出线程，消费者）
    class OutThread extends Thread{
        PipedOutputStream pos = null;
        PipedInputStream pis = null ;
        OutThread(PipedOutputStream pos,PipedInputStream pis ){
            this.pos = pos;
            this.pis = pis;
        }
        public void run() {
            //读取数据
            String m = "";
            byte[] b = new byte[1024];
            try {
                int len ;
                len = pis.read(b);
                m = m+ new String(b);
                while(len!=-1) {
                    len = pis.read(b);
                    m = m+ new String(b);
                }
                //关闭资源
                pis.close();
                System.out.println(m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
