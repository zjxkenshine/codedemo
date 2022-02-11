package com.kenshine.chapter06;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 21:26
 * @description：原子累加器
 * @modified By：
 * @version: $
 */
public class Test09_LongAdder {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            demo(()->new AtomicLong(0),(ref)->ref.getAndIncrement());
        }

        for (int i = 0; i < 5; i++) {
            demo(()->new LongAdder(),(ref)->ref.increment());
        }
    }
    private static <T> void demo(Supplier<T> supplier, Consumer<T> consumer) {
        ArrayList<Thread> list = new ArrayList<>();

        T adder = supplier.get();
        // 4 个线程，每人累加 50 万
        for (int i = 0; i < 4; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < 500000; j++) {
                    consumer.accept(adder);
                }
            }));
        }
        long start = System.nanoTime();
        list.forEach(t -> t.start());
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(adder + " cost:" + (end - start)/1000_000);
    }
}
