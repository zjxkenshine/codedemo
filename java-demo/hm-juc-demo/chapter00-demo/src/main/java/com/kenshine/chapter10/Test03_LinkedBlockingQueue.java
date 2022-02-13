package com.kenshine.chapter10;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 19:00
 * @description： LinkedBlockingQueue 使用
 * @modified By：
 * @version: $
 * 一、添加元素
 * 1、add 方法：如果队列已满，报java.lang.IllegalStateException: Queue full 错误
 * 2、offer 方法：如果队列已满，程序正常运行，只是不再新增元素
 * 3、put 方法：如果队列已满，阻塞
 *
 * 二、取元素
 * 1、poll 方法：弹出队顶元素，队列为空时返回null
 * 2、peek 方法：返回队列顶元素，但顶元素不弹出，队列为空时返回null
 * 3、take 方法：当队列为空，阻塞
 */
public class Test03_LinkedBlockingQueue {

    private static LinkedBlockingQueue<String> linkedBlockingQueue;

    public static void main(String[] args) {
        linkedBlockingQueue = new LinkedBlockingQueue<>(20);
        // 1、add 方法:队列已满，报java.lang.IllegalStateException: Queue full 错误
        System.out.println("-----add  方法-----");
        for (int i = 0; i < 5; i++) {
            linkedBlockingQueue.add(String.valueOf(i));
        }
        System.out.println(linkedBlockingQueue.size());

        // 2、offer 方法，队列已满，程序正常运行，只是不再新增元素
        System.out.println("-----offer方法-----");
        for (int i = 0; i < 20; i++) {
            linkedBlockingQueue.offer(String.valueOf(i));
        }
        System.out.println(linkedBlockingQueue.size());

        System.out.println("-----poll 方法-----");
        // 3、poll 方法，弹出队顶元素，队列为空时返回null
        for (int i = 0; i < 6; i++) {
            String e = linkedBlockingQueue.poll();
            System.out.println("取出元素：" + e);
        }

        System.out.println("-----peek 方法-----");
        // 4、peek 方法，返回队列顶元素，但顶元素不弹出，队列为空时返回null
        for (int i = 0; i < 5; i++) {
            String e = linkedBlockingQueue.peek();
            System.out.println("取出元素：" + e);
        }

        System.out.println("-----take 方法-----");
        // 5、take 方法，当队列为空，阻塞
        for (int i = 0; i < 10; i++) {
            String e = null;
            try {
                e = linkedBlockingQueue.take();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("取出元素：" + e);
        }

        System.out.println("-----put  方法-----");
        // 6、put 方法，当队列满时，阻塞
        for (int i = 0; i < 30; i++) {
            try {
                String e = String.valueOf(i);
                linkedBlockingQueue.put(e);
                System.out.println("放入元素：" + e);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("队列深度：" + linkedBlockingQueue.size());
    }
}
