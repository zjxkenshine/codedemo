package com.kenshine.quickperf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quickperf.annotation.DebugQuickPerf;
import org.quickperf.annotation.DisplayAppliedAnnotations;
import org.quickperf.annotation.ExpectMaxExecutionTime;
import org.quickperf.annotation.MeasureExecutionTime;
import org.quickperf.junit4.QuickPerfJUnitRunner;

/**
 * @author by kenshine
 * @Classname QuickPerfTest
 * @Description QuickPerf使用测试 JVM参数
 * @Date 2023-12-06 13:26
 * @modified By：
 * @version: 1.0$
 *
 * junit4方式 @RunWith(QuickPerfJUnitRunner.class)
 */
@RunWith(QuickPerfJUnitRunner.class)
public class QuickPerfCoreTest {

    /**
     * 打印执行时间
     */
    @MeasureExecutionTime
    @Test
    public void test01() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    /**
     * 超过执行时间失败
     */
    @ExpectMaxExecutionTime(seconds = 1)
    @MeasureExecutionTime
    @Test
    public void test02() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    /**
     * 显示应用的QuickPerf注解
     */
    @DisplayAppliedAnnotations
    @MeasureExecutionTime
    @Test
    public void test03() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    /**
     * 显示调试信息
     */
    @DebugQuickPerf
    @Test
    public void test04() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }
}
