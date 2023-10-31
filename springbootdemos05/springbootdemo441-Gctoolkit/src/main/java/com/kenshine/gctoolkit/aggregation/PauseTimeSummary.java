package com.kenshine.gctoolkit.aggregation;

/**
 * GC log的运行时代理，统计方法挂起时间，挂起百分比
 */
public class PauseTimeSummary extends PauseTimeAggregation {

    private double totalPauseTime;

    @Override
    public boolean hasWarning() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void recordPauseDuration(double duration) {
        totalPauseTime += duration;
    }

    /**
     * 获取应用程序暂停垃圾收集的总时间.
     */
    public double getTotalPauseTime() {
        return totalPauseTime;
    }

    /**
     * 获取暂停百分比
     */
    public double getPercentPaused() {
        return (totalPauseTime / super.estimatedRuntime()) * 100.0D;
    }
}
