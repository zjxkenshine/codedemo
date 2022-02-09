package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/9 11:22
 * @description：Synchronized锁对象改进
 * @modified By：
 * @version: $
 */
@Slf4j(topic="c.test02")
public class Test02_Synchronized02 {
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 1;i < 5000; i++){
                room.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1;i < 5000; i++){
                room.decrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("count的值是{}",room.getCounter());
    }
}

class Room{
    private int counter=0;

    public void increment(){
        synchronized(this){
            counter++;
        }
    }

    public void decrement(){
        synchronized(this){
            counter--;
        }
    }

    public int getCounter(){
        synchronized(this){
            return counter;
        }
    }
}
