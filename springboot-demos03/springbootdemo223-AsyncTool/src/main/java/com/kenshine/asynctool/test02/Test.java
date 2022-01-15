package com.kenshine.asynctool.test02;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.wrapper.WorkerWrapper;
import com.kenshine.asynctool.domain.User;

import java.util.concurrent.ExecutionException;


/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 11:08
 * @description：串行方式1.3后新写法
 * @modified By：
 * @version: $
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DeWorker1 w = new DeWorker1();
        DeWorker2 w1 = new DeWorker2();
        DeWorker3 w2 = new DeWorker3();

        WorkerWrapper<User, String> workerWrapper2 =  new WorkerWrapper.Builder<User, String>()
                .worker(w2)
                .callback(w2)
                .id("third")
                .build();

        WorkerWrapper<String, User> workerWrapper1 = new WorkerWrapper.Builder<String, User>()
                .worker(w1)
                .callback(w1)
                .id("second")
                .next(workerWrapper2)
                .build();

        WorkerWrapper<String, User> workerWrapper = new WorkerWrapper.Builder<String, User>()
                .worker(w)
                .param("0")
                .id("first")
                .next(workerWrapper1)
                .callback(w)
                .build();

        //V1.3后，不用给wrapper setParam了，直接在worker的action里自行根据id获取即可

        Async.beginWork(3500, workerWrapper);

        System.out.println(workerWrapper2.getWorkResult());
        Async.shutDown();
    }
}
