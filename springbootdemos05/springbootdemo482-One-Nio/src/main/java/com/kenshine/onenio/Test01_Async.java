package com.kenshine.onenio;

import one.nio.async.AsyncExecutor;
import one.nio.async.CombinedFuture;
import one.nio.async.ParallelTask;
import one.nio.async.SettableFuture;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by kenshine
 * @Classname Test01_Async
 * @Description async包使用测试
 * @Date 2023-11-13 13:28
 * @modified By：
 * @version: 1.0$
 */
public class Test01_Async {

    /**
     * SettableFuture：可设置值的future，未设置值时get会等待
     */
    @Test
    public void testSettableFuture() throws ExecutionException, InterruptedException {
        SettableFuture<String> sf = new SettableFuture<>();
        ((Runnable) () -> {
            try {
                Thread.sleep(1000);
                sf.set("test");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();
        String s=sf.get();
        System.out.println(s);
    }

    /**
     * AsyncExecutor.submitAll 提交多个线程并合并结果
     * 返回CombinedFuture
     */
    @Test
    public void testAsyncExecutorSubmitAll() throws ExecutionException, InterruptedException {
        CombinedFuture<String> s=AsyncExecutor.submitAll(() -> "test01",() -> "test02");
        List<String> list=s.get();
        System.out.println(list);
    }

    /**
     * AsyncExecutor.fork复制任务
     * ParallelTask实现
     */
    @Test
    public void testAsyncExecutorFork(){
        AtomicInteger a=new AtomicInteger();
        // 四个线程
        AsyncExecutor.fork(4,new ParallelTask() {
            @Override
            public void execute(int i, int i1) throws Exception {
                a.addAndGet(i);
                System.out.println("执行线程"+i+"，共"+i1);
            }
        });
        // 0+1+2+3
        System.out.println(a);
    }

}
