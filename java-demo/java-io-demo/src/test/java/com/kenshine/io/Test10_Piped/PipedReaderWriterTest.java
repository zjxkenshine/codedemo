package com.kenshine.io.Test10_Piped;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 9:24
 * @description：管道字符流
 * @modified By：
 * @version: $
 * PipedWriter 是字符管道输出流，它继承于Writer。
 * PipedReader 是字符管道输入流，它继承于Reader。
 * PipedWriter和PipedReader的作用是可以通过管道进行线程间的通讯。在使用管道通信时，必须将PipedWriter和PipedReader配套使用
 *
 */
public class PipedReaderWriterTest {

    @Test
    public void test01(){
        Sender t1 = new Sender();
        Receiver t2 = new Receiver();
        PipedWriter out = t1.getWriter();
        PipedReader in = t2.getReader();
        try {
            //管道连接。下面2句话的本质是一样。
            //out.connect(in);
            in.connect(out);

            /**
             * Thread类的START方法：
             * 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
             * 结果是两个线程并发地运行；当前线程（从调用返回给 start 方法）和另一个线程（执行其 run 方法）。
             * 多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
             */
            t1.start();
            t2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
