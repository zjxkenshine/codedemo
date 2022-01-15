package com.kenshine.asynctool.test01;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import com.kenshine.asynctool.domain.User;

import java.util.concurrent.ExecutionException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 11:03
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CustomWorker1 work1 = new CustomWorker1();
        CustomWorker2 work2 = new CustomWorker2();
        CustomWorker3 work3 = new CustomWorker3();

        //组合worker和callback
        WorkerWrapper<WorkResult<User>, String> workerWrapper2 =  new WorkerWrapper.Builder<WorkResult<User>, String>()
                .worker(work3)
                .callback(work3)
                .id("third")
                .build();

        WorkerWrapper<WorkResult<User>, User> workerWrapper1 = new WorkerWrapper.Builder<WorkResult<User>, User>()
                .worker(work2)
                .callback(work2)
                .id("second")
                //下一个执行workerWrapper2
                .next(workerWrapper2)
                .build();

        WorkerWrapper<String, User> workerWrapper = new WorkerWrapper.Builder<String, User>()
                .worker(work1)
                .param("0")
                .id("first")
                //下一个执行workerWrapper1
                .next(workerWrapper1, true)
                .callback(work1)
                .build();

        //虽然尚未执行，但是也可以先取得结果的引用，作为下一个任务的入参。V1.2前写法，需要手工给
        //V1.3后，不用给wrapper setParam了，直接在worker的action里自行根据id获取即可
        WorkResult<User> result = workerWrapper.getWorkResult();
        WorkResult<User> result1 = workerWrapper1.getWorkResult();
        workerWrapper1.setParam(result);
        workerWrapper2.setParam(result1);

        Async.beginWork(3500, workerWrapper);

        System.out.println(workerWrapper2.getWorkResult());
        Async.shutDown();

    }
}
