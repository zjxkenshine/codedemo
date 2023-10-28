package com.kenshine.testcoordinator;

import com.moscona.util.testing.TestCoordinator;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertTrue;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 测试
 * @Date 2023-10-28 8:22
 * @modified By：
 * @version: 1.0$
 */
public class CoordinatorTest {
    // 250ms
    public static final int TEST_TIMEOUT = 250;
    Executor background = null;
    AtomicBoolean trueExpectation = null;

    @Before
    public void setup() {
        background = Executors.newSingleThreadExecutor((r) -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        trueExpectation = new AtomicBoolean(false);
    }

    // 延时
    private void delayExecution(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // 执行任务
    private void doBackgroundJob(TestCoordinator coord) {
        background.execute(makeBackgroundJob(coord));
    }

    private Runnable makeBackgroundJob(TestCoordinator coord) {
        return () -> {
            trueExpectation.set(true);
            delayExecution(20);
            coord.finishTest();
        };
    }

    @Test(timeout = TEST_TIMEOUT)
    public void testWaitsToFinish() {
        final TestCoordinator coord = new TestCoordinator();
        doBackgroundJob(coord);
        coord.delayTestFinish();
        assertTrue("background task not executed", trueExpectation.get());
    }

    /**
     * 等待超时
     */
    @Test(timeout = TEST_TIMEOUT)
    public void testWaitsToFinish_WithTimeout() throws Exception {
        final TestCoordinator coord = new TestCoordinator();
        doBackgroundJob(coord);
        //默认毫秒
        final boolean result = coord.delayTestFinish(1000);
        assertTrue("background task not executed (delayed wait)", trueExpectation.get());
        assertTrue("task should not have timed out", result);
    }

    /**
     *
     */
    @Test(timeout = 1000)
    public void testWaitsToFinish_WithTimeoutAndTimeUnit() throws Exception {
        final TestCoordinator coord = new TestCoordinator();
        doBackgroundJob(coord);
        final boolean result = coord.delayTestFinish(1, TimeUnit.SECONDS);
        assertTrue("background task not executed (delayed wait)", trueExpectation.get());
        assertTrue("task should not have timed out", result);
    }

    /**
     * 两次调用
     */
    @Test(timeout = 1000)
    public void testWaitsToFinishCanBeCalledTwice() throws Exception {
        final TestCoordinator coord = new TestCoordinator();
        final Runnable task = makeBackgroundJob(coord);
        background.execute(task);
        coord.delayTestFinish();
        assertTrue("1st task not called!", trueExpectation.get());

        trueExpectation.set(false);
        background.execute(task);
        coord.delayTestFinish();
        assertTrue("2nd task not called!", trueExpectation.get());
    }
}
