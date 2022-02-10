package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/10 15:23
 * @description：生产者消费者模式
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.Test09")
public class Test09_Productor {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);
        for (int i = 0; i < 4; i++) {
            int id = i;
            new Thread(() -> {
                log.debug("download...");
                //List<String> response = Downloader.download();
                log.debug("try put message({})", id);
                messageQueue.put(new Message(id, "值"+id));
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            while (true) {
                Message message = messageQueue.take();
                String response = (String) message.getMessage();
                log.debug("take message({}):{}", message.getId(), response);
            }
        }, "消费者").start();
    }
}

// 消息队列类 java 线程之间通信
@Slf4j(topic = "c.MessageQueue")
class MessageQueue{
    // 消息队列集合
    private LinkedList<Message> list;
    // 队列容量
    private int capcity;

    public MessageQueue(int capacity){
        this.capcity = capacity;
        list = new LinkedList<>();
    }

    // 获取消息
    public Message take(){
        // 检查消息对象是否为空
        synchronized (list){
            while (list.isEmpty()){
                log.debug("队列为空, 消费者等待");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 从队列头部获取消息返回
            Message message = list.removeFirst();
            list.notifyAll();
            return message;
        }
    }

    // 存入消息
    public void put(Message message){
        synchronized (list){
            // 检查对象是否已满
            while (list.size() == capcity){
                log.debug("库存已达上限, 生产者等待");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            list.notifyAll();
        }
    }
}

// 带id的消息
class Message {
    private int id;
    private Object message;

    public Message(int id, Object message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public Object getMessage() {
        return message;
    }
}
