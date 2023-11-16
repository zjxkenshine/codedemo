package com.kenshine.jctools;

import org.jctools.queues.*;
import org.junit.Test;

import java.util.Queue;

/**
 * @author by kenshine
 * @Classname TestQueue
 * @Description 非阻塞队列
 * @Date 2023-11-16 8:45
 * @modified By：
 * @version: 1.0$
 */
public class TestQueue {

    @Test
    public void testQueue(){
        // spsc-有界/无界队列
        Queue<String> spscArrayQueue = new SpscArrayQueue(16);
        Queue<String> spscUnboundedArrayQueue = new SpscUnboundedArrayQueue(2);
        // spmc-有界队列
        Queue<String> spmcArrayQueue = new SpmcArrayQueue<>(16);
        // mpsc-有界/无界队列
        Queue<String> mpscArrayQueue = new MpscArrayQueue<>(16);
        Queue<String> mpscChunkedArrayQueue = new MpscChunkedArrayQueue<>(1024, 8 * 1024);
        Queue<String> mpscUnboundedArrayQueue = new MpscUnboundedArrayQueue<>(2);
        // mpmc-有界队列
        Queue<String> mpmcArrayQueue = new MpmcArrayQueue<>(16);
    }
}
