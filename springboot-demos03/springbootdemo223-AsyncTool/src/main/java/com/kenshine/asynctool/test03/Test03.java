package com.kenshine.asynctool.test03;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.executor.timer.SystemClock;
import com.jd.platform.async.wrapper.WorkerWrapper;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 11:28
 * @description：
 * @modified By：
 * @version: $
 *
 * 参考源代码test
 */
public class Test03 {

    /**
     * 3个并行，测试不同时间的超时
     */
    @Test
    public void testNormal() throws InterruptedException, ExecutionException {
        ParWorker w = new ParWorker();
        ParWorker1 w1 = new ParWorker1();
        ParWorker2 w2 = new ParWorker2();

        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .build();

        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .build();

        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .callback(w)
                .param("0")
                .build();

        long now = SystemClock.now();
        System.out.println("begin-" + now);

        Async.beginWork(1500, workerWrapper, workerWrapper1, workerWrapper2);
//        Async.beginWork(800, workerWrapper, workerWrapper1, workerWrapper2);
//        Async.beginWork(1000, workerWrapper, workerWrapper1, workerWrapper2);

        System.out.println("end-" + SystemClock.now());
        System.err.println("cost-" + (SystemClock.now() - now));
        System.out.println(Async.getThreadCount());

        System.out.println(workerWrapper.getWorkResult());
        Async.shutDown();
    }

    /**
     * 0,2同时开启,1在0后面
     * 0---1
     * 2
     */
    @Test
    public void testMulti() throws ExecutionException, InterruptedException {
        ParWorker w = new ParWorker();
        ParWorker1 w1 = new ParWorker1();
        ParWorker2 w2 = new ParWorker2();

        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .build();

        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .build();

        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .callback(w)
                .param("0")
                .next(workerWrapper1)
                .build();

        long now = SystemClock.now();
        System.out.println("begin-" + now);

        Async.beginWork(2500, workerWrapper, workerWrapper2);

        System.out.println("end-" + SystemClock.now());
        System.err.println("cost-" + (SystemClock.now() - now));

        Async.shutDown();
    }

    /**
     * 0,2同时开启,1在0后面. 组超时,则0和2成功,1失败
     * 0---1
     * 2
     */
    @Test
    public void testMultiError() throws ExecutionException, InterruptedException {
        ParWorker w = new ParWorker();
        ParWorker1 w1 = new ParWorker1();
        ParWorker2 w2 = new ParWorker2();

        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .build();

        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .build();

        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .callback(w)
                .param("0")
                .next(workerWrapper1)
                .build();

        long now = SystemClock.now();
        System.out.println("begin-" + now);

        Async.beginWork(1500, workerWrapper, workerWrapper2);

        System.out.println("end-" + SystemClock.now());
        System.err.println("cost-" + (SystemClock.now() - now));

        Async.shutDown();
    }


    /**
     * 0执行完,同时1和2, 1\2都完成后3
     *     1
     * 0       3
     *     2
     */
    @Test
    public void testMulti3Reverse() throws ExecutionException, InterruptedException {
        ParWorker w = new ParWorker();
        ParWorker1 w1 = new ParWorker1();
        ParWorker2 w2 = new ParWorker2();
        ParWorker3 w3 = new ParWorker3();

        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .callback(w)
                .param("0")
                .build();

        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .depend(workerWrapper)
                .build();

        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .depend(workerWrapper)
                .build();

        WorkerWrapper<String, String> workerWrapper3 =  new WorkerWrapper.Builder<String, String>()
                .worker(w3)
                .callback(w3)
                .param("3")
                .depend(workerWrapper1, workerWrapper2)
                .build();


        long now = SystemClock.now();
        System.out.println("begin-" + now);

        Async.beginWork(3100, workerWrapper);
//        Async.beginWork(2100, workerWrapper);

        System.out.println("end-" + SystemClock.now());
        System.err.println("cost-" + (SystemClock.now() - now));

        System.out.println(Async.getThreadCount());
        Async.shutDown();
    }

    /**
     * 0执行完,同时1和2, 1\2都完成后3，2耗时2秒，1耗时1秒。3会等待2完成
     *     1
     * 0       3
     *     2
     *
     * 执行结果0，1，2，3
     */
    @Test
    public void testMulti4() throws ExecutionException, InterruptedException {
        ParWorker w = new ParWorker();
        ParWorker1 w1 = new ParWorker1();

        ParWorker2 w2 = new ParWorker2();
        w2.setSleepTime(2000);

        ParWorker3 w3 = new ParWorker3();

        WorkerWrapper<String, String> workerWrapper3 =  new WorkerWrapper.Builder<String, String>()
                .worker(w3)
                .callback(w3)
                .param("3")
                .build();

        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .next(workerWrapper3)
                .build();

        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .next(workerWrapper3)
                .build();

        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .callback(w)
                .param("0")
                .next(workerWrapper1, workerWrapper2)
                .build();

        long now = SystemClock.now();
        System.out.println("begin-" + now);

        //正常完毕
        Async.beginWork(4100, workerWrapper);
        //3会超时
//        Async.beginWork(3100, workerWrapper);
        //2,3会超时
//        Async.beginWork(2900, workerWrapper);

        System.out.println("end-" + SystemClock.now());
        System.err.println("cost-" + (SystemClock.now() - now));

        System.out.println(Async.getThreadCount());
        Async.shutDown();
    }


    /**
     * 0执行完,同时1和2, 1\2 任何一个执行完后，都执行3
     *     1
     * 0       3
     *     2
     *
     * 则结果是：
     * 0，2，3，1
     * 2，3分别是500、400.3执行完毕后，1才执行完
     */
    @Test
    public void testMulti5() throws ExecutionException, InterruptedException {
        ParWorker w = new ParWorker();
        ParWorker1 w1 = new ParWorker1();

        ParWorker2 w2 = new ParWorker2();
        w2.setSleepTime(500);

        ParWorker3 w3 = new ParWorker3();
        w3.setSleepTime(400);

        WorkerWrapper<String, String> workerWrapper3 =  new WorkerWrapper.Builder<String, String>()
                .worker(w3)
                .callback(w3)
                .param("3")
                .build();

        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .next(workerWrapper3, false)
                .build();

        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .next(workerWrapper3, false)
                .build();

        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .callback(w)
                .param("0")
                .next(workerWrapper1, workerWrapper2)
                .build();

        long now = SystemClock.now();
        System.out.println("begin-" + now);

        //正常完毕
        Async.beginWork(4100, workerWrapper);

        System.out.println("end-" + SystemClock.now());
        System.err.println("cost-" + (SystemClock.now() - now));

        System.out.println(Async.getThreadCount());
        Async.shutDown();
    }


    /**
     * 0执行完,同时1和2, 必须1执行完毕后，才能执行3. 无论2是否领先1完毕，都要等1
     *     1
     * 0       3
     *     2
     *
     * 则结果是：
     * 0，2，1，3
     *
     * 2，3分别是500、400.2执行完了，1没完，那就等着1完毕，才能3
     */
    @Test
    public void testMulti6() throws ExecutionException, InterruptedException {
        ParWorker w = new ParWorker();
        ParWorker1 w1 = new ParWorker1();

        ParWorker2 w2 = new ParWorker2();
        w2.setSleepTime(500);

        ParWorker3 w3 = new ParWorker3();
        w3.setSleepTime(400);

        WorkerWrapper<String, String> workerWrapper3 =  new WorkerWrapper.Builder<String, String>()
                .worker(w3)
                .callback(w3)
                .param("3")
                .build();

        //设置2不是必须
        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .next(workerWrapper3, false)
                .build();
        // 设置1是必须的
        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .next(workerWrapper3, true)
                .build();

        WorkerWrapper<String, String> workerWrapper0 =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .callback(w)
                .param("0")
                .next(workerWrapper2, workerWrapper1)
                .build();


        long now = SystemClock.now();
        System.out.println("begin-" + now);

        //正常完毕
        Async.beginWork(4100, workerWrapper0);

        System.out.println("end-" + SystemClock.now());
        System.err.println("cost-" + (SystemClock.now() - now));

        System.out.println(Async.getThreadCount());
        Async.shutDown();
    }

}
