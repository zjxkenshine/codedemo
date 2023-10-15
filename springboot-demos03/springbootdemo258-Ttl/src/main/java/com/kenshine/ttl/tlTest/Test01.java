package com.kenshine.ttl.tlTest;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/15 23:46
 * @description： ThreadLocal无法传递父线程本地变量
 * @modified By：
 * @version: $
 */
public class Test01 {
    private static ThreadLocal tl = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        tl.set(1);
        System.out.println(String.format("当前线程名称: %s, main方法内获取线程内数据为: %s",
                Thread.currentThread().getName(), tl.get()));
        fc();
        new Thread(Test01::fc).start();
    }

    private static void fc() {
        System.out.println(String.format("当前线程名称: %s, fc方法内获取线程内数据为: %s",
                Thread.currentThread().getName(), tl.get()));
    }
}
