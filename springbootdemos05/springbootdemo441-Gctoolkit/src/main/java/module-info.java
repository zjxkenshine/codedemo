// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

/**
 * Contains an Aggregator and an Aggregation
 */
module com.kenshine.gctoolkit{
    requires com.microsoft.gctoolkit.api;
    requires java.logging;

    exports com.kenshine.gctoolkit;

    exports com.kenshine.gctoolkit.aggregation to
            com.microsoft.gctoolkit.api;

    provides com.microsoft.gctoolkit.aggregator.Aggregation with
             com.kenshine.gctoolkit.aggregation.HeapOccupancyAfterCollectionSummary,
             com.kenshine.gctoolkit.aggregation.PauseTimeSummary,
             com.kenshine.gctoolkit.aggregation.CollectionCycleCountsSummary;
}
