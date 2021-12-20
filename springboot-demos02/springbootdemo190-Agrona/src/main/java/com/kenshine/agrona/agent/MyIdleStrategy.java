package com.kenshine.agrona.agent;

import org.agrona.concurrent.IdleStrategy;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 9:49
 * @description：自定义空闲策略 参考了SleepingMillisIdleStrategy
 * @modified By：
 * @version: $
 */
public class MyIdleStrategy implements IdleStrategy {

    /**
     * 执行当前空闲操作
     * @param workCount 用于统计工作状态的
     */
    @Override
    public void idle(int workCount) {
        if (workCount > 0) {
            return;
        }

        try {
            //等待1000ms
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //中断当前线程
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 执行当前空闲操作
     */
    @Override
    public void idle() {
        try {
            //等待1000ms
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //中断当前线程
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 重置内部状态，为再次进入空闲状态做准备
     * 这里不需要进行重置
     */
    @Override
    public void reset() {
    }
}
