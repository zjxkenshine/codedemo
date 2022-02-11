package com.kenshine.chapter06;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 22:18
 * @description：Unsafe 模拟实现原子整数
 * @modified By：
 * @version: $
 * 会报错：https://blog.csdn.net/weixin_44671737/article/details/113786640
 */
public class Test12_Unsafe03 {
    public static void main(String[] args) {
        Account1.demo(new MyAtomicInteger(10000));
    }
}

class MyAtomicInteger implements Account1 {
    private volatile Integer value;
    private static final Unsafe UNSAFE = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = UNSAFE.objectFieldOffset
                    (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    public MyAtomicInteger(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }

    public void decrement(Integer amount) {
        while (true) {
            Integer preVal = this.value;
            Integer nextVal = preVal - amount;
            if(UNSAFE.compareAndSwapObject(this, valueOffset, preVal, nextVal)) {
                break;
            }
        }
    }

    @Override
    public Integer getBalance() {
        return get();
    }

    @Override
    public void withdraw(Integer amount) {
        decrement(amount);
    }
}
interface Account1 {
    // 获取余额
    Integer getBalance();

    // 取款
    void withdraw(Integer amount);

    /**
     * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
     * 如果初始余额为 10000 那么正确的结果应当是 0
     */
    static void demo(Account1 account) {
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        long start = System.nanoTime();
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance()
                + " cost: " + (end-start)/1000_000 + " ms");
    }
}