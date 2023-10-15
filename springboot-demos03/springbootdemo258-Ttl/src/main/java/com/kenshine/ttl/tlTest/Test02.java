package com.kenshine.ttl.tlTest;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/15 23:48
 * @description： 在子线程内设置tl的值，单独处理
 * @modified By：
 * @version: $
 */
public class Test02 {
    private static ThreadLocal tl = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        tl.set(1);
        System.out.println(String.format("当前线程名称: %s, main方法内获取线程内数据为: %s",
                Thread.currentThread().getName(), tl.get()));
        fc();
        new Thread(()->{
            tl.set(2); //在子线程里设置上下文内容为2
            fc();
        }).start();
        //保证下面fc执行一定在上面异步代码之后执行
        Thread.sleep(1000L);
        //继续在主线程内执行，验证上面那一步是否对主线程上下文内容造成影响
        // 主线程和子线程都可以获取到自己的那份上下文里的内容，而且互不影响
        fc();
    }

    private static void fc() {
        System.out.println(String.format("当前线程名称: %s, fc方法内获取线程内数据为: %s",
                Thread.currentThread().getName(), tl.get()));
    }
}
