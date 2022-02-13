package com.kenshine.chapter10;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 17:58
 * @description：ConcurrentHashMap使用示例2
 * @modified By：
 * @version: $
 * https://blog.csdn.net/zero__007/article/details/49833819
 */
public class Test02_ConcurrentHashMap02 {
    public static void main(String[] args) {
        // 错误用法
        demo1();
        // 正确用法
        demo2();
        // AtomicInteger改进
        demo3();
    }

    public static void demo1() {
        final Map<String, Integer> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Integer value = count.get("a");
                    if (null == value) {
                        count.put("a", 1);
                    } else {
                        count.put("a", value + 1);
                    }
                }
                endLatch.countDown();
            }
        };
        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 正确用法，需要处理Null值
    public static void demo2() {
        final Map<String, Integer> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Integer oldValue, newValue;
                for (int i = 0; i < 5; i++) {
                    while (true) {
                        oldValue = count.get("a");
                        if (null == oldValue) {
                            newValue = 1;
                            if (count.putIfAbsent("a", newValue) == null) {
                                break;
                            }
                        } else {
                            newValue = oldValue + 1;
                            if (count.replace("a", oldValue, newValue)) {
                                break;
                            }
                        }
                    }
                }
                endLatch.countDown();
            }
        };
        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // AtomicInteger改进
    public static void demo3() {
        final Map<String, AtomicInteger> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                AtomicInteger oldValue;
                for (int i = 0; i < 5; i++) {
                    oldValue = count.get("a");
                    if (null == oldValue) {
                        AtomicInteger zeroValue = new AtomicInteger(0);
                        oldValue = count.putIfAbsent("a", zeroValue);
                        if (null == oldValue) {
                            oldValue = zeroValue;
                        }
                    }
                    oldValue.incrementAndGet();
                }
                endLatch.countDown();
            }
        };
        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




