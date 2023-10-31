package com.kenshine.gctoolkit.aggregation;

import com.microsoft.gctoolkit.aggregator.Aggregation;
import com.microsoft.gctoolkit.aggregator.Collates;
import com.microsoft.gctoolkit.event.GarbageCollectionTypes;
import com.microsoft.gctoolkit.time.DateTimeStamp;

/**
 * GC后堆占用统计接口
 */
@Collates(HeapOccupancyAfterCollection.class)
public abstract class HeapOccupancyAfterCollectionAggregation extends Aggregation {

    abstract public void addDataPoint(GarbageCollectionTypes gcType, DateTimeStamp timeStamp, long heapOccupancy);

}
