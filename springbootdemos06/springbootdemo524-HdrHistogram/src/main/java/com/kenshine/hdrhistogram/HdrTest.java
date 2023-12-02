package com.kenshine.hdrhistogram;

import org.HdrHistogram.Histogram;

/**
 * @author by kenshine
 * @Classname HdrTest
 * @Description 直方图统计算法
 * @Date 2023-12-02 9:51
 * @modified By：
 * @version: 1.0$
 */
public class HdrTest {
    public static void main(String[] args) {
        // 需指定预估的最大值
        Histogram histogram = new Histogram(5400000000000L, 4);
        for(int i = 1; i < 10000000; i = i * 2) {
            // 塞入需要计算的值
            histogram.recordValue(i);
        }
        long t1 = System.nanoTime();
        // 求出平均值
        double a = histogram.getMean();
        long t2 = System.nanoTime();
        System.out.println(a + " " + (t2 - t1) + "ns");
    }
}
