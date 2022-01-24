package com.kenshine.netty.demo04_Future_Promise;

import java.util.concurrent.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/24 21:19
 * @description：
 * @modified By：
 * @version: $
 */
public class JdkFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "JdkFuture");
            }
        };
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), factory);

        // 获得Future对象
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(1);
                return 50;
            }
        });

        // 通过阻塞的方式，获得运行结果
        System.out.println(future.get());
    }
}
