package com.kenshine.jconch;

import com.jconch.testing.TestCoordinator;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author by kenshine
 * @Classname TestCoordinatorTest
 * @Description 测试TestCoordinator
 * @Date 2023-10-27 10:30
 * @modified By：
 * @version: 1.0$
 */
public class TestCoordinatorTest {
    private ExecutorService executor;


    @Before
    public void setUp() throws Exception {
        executor = Executors.newSingleThreadExecutor();
    }


    @Test
    public void testWaitsToFinish() throws Exception {
        final TestCoordinator coord = new TestCoordinator();
        final AtomicBoolean wasCalled = new AtomicBoolean(false);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                wasCalled.set(true);
                // 结束
                coord.finishTest();
            }
        });

        coord.delayTestFinish();
        assertTrue("task not called!", wasCalled.get());
    }

    /**
     * 超时
     */
    @Test(timeout = 5000)
    public void testErrorCondition_WithTimeout() throws Exception {
        final TestCoordinator coord = new TestCoordinator();
        boolean result = coord.delayTestFinish(2000);
        assertFalse("task should have timed out", result);
    }

    /**
     * TimeUnit使用
     * @throws Exception
     */
    @Test(timeout = 1000)
    public void testWaitsToFinish_WithTimeoutAndTimeUnit() throws Exception {
        final TestCoordinator coord = new TestCoordinator();
        final AtomicBoolean wasCalled = new AtomicBoolean(false);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                wasCalled.set(true);
                coord.finishTest();
            }
        });
        final boolean result = coord.delayTestFinish(1, TimeUnit.SECONDS);
        assertTrue("task not called!", wasCalled.get());
        assertTrue("task should not have timed out", result);
    }

}
