package com.kenshine.gctoolkit.aggregation;

import com.microsoft.gctoolkit.aggregator.Aggregation;
import com.microsoft.gctoolkit.aggregator.Collates;
import com.microsoft.gctoolkit.event.GarbageCollectionTypes;

/**
 * GC 循环计数器 聚合接口
 */
@Collates(CollectionCycleCountsAggregator.class)
public abstract class CollectionCycleCountsAggregation extends Aggregation {

    abstract public void count(GarbageCollectionTypes gcType);

}
