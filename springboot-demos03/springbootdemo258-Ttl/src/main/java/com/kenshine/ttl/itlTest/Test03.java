package com.kenshine.ttl.itlTest;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 0:03
 * @description： InheritableThreadLocal 父子线程传值
 * @modified By：
 * @version: $
 */
public class Test03 {
    private static ThreadLocal tl = new InheritableThreadLocal<>();
    private static ThreadLocal tl2 = new InheritableThreadLocal<>();

    public static void main(String[] args) throws Exception {
        tl.set(1);

        Hello hello = new Hello();
        hello.setName("init");
        tl2.set(hello);
        System.out.println(String.format("当前线程名称: %s, main方法内获取线程内数据为: tl = %s，tl2.name = %s",
                Thread.currentThread().getName(), tl.get(), ((Hello)tl2.get()).getName()));
        fc();
        new Thread(() -> {
            Hello hello1 = (Hello)tl2.get();
            hello1.setName("init2");
            fc();
        }).start();
        Thread.sleep(1000L); //保证下面fc执行一定在上面异步代码之后执行
        fc(); //子线程修改的值父线程也会获取到
    }

    private static void fc() {
        System.out.println(String.format("当前线程名称: %s, fc方法内获取线程内数据为: tl = %s，tl2.name = %s",
                Thread.currentThread().getName(), tl.get(), ((Hello)tl2.get()).getName()));
    }
}
