package com.kenshine.gctoolkit.aggregation;

import com.microsoft.gctoolkit.aggregator.Aggregation;
import com.microsoft.gctoolkit.aggregator.Collates;

/**
 * GC 暂停时间API
 */
@Collates(PauseTimeAggregator.class)
public abstract class PauseTimeAggregation extends Aggregation {
    /**
     * 记录暂停事件的持续时间
     */
    public abstract void recordPauseDuration(double duration);
}
