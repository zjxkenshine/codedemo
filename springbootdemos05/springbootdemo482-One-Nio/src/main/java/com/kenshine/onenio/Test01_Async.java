package com.kenshine.onenio;

import one.nio.async.AsyncExecutor;
import one.nio.async.SettableFuture;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

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
}
