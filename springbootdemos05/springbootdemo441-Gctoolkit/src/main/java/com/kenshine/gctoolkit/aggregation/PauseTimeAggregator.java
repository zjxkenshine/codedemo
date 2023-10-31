package com.kenshine.gctoolkit.aggregation;

import com.microsoft.gctoolkit.aggregator.Aggregates;
import com.microsoft.gctoolkit.aggregator.Aggregator;
import com.microsoft.gctoolkit.aggregator.EventSource;
import com.microsoft.gctoolkit.event.g1gc.G1GCPauseEvent;

/**
 * 提取暂停时间的聚合器
 */
@Aggregates({EventSource.G1GC})
public class PauseTimeAggregator extends Aggregator<PauseTimeAggregation> {

    public PauseTimeAggregator(PauseTimeAggregation aggregation) {
        super(aggregation);
        register(G1GCPauseEvent.class, this::process);
    }

    private void process(G1GCPauseEvent event) {
        aggregation().recordPauseDuration(event.getDuration());
    }
}
