package com.kenshine.jqwik.parameter;

import net.jqwik.api.*;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

/**
 * @author by kenshine
 * @Classname RandomDistribution
 * @Description 随机数字分布
 * @Date 2024-01-18 12:33
 * @modified By：
 * @version: 1.0$
 */
public class RandomDistributionTest {
    @Property(generation = GenerationMode.RANDOMIZED)
    @StatisticsReport(format = Histogram.class)
    void gaussianDistributedIntegers(@ForAll("gaussians") int aNumber) {
        Statistics.collect(aNumber);
    }

    @Provide
    Arbitrary<Integer> gaussians() {
        return Arbitraries
                .integers()
                .between(0, 20)
                .shrinkTowards(10)
                .withDistribution(RandomDistribution.gaussian());
    }
}
