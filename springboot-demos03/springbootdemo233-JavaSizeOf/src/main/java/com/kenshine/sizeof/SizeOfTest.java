package com.kenshine.sizeof;

import com.carrotsearch.sizeof.RamUsageEstimator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/20 18:35
 * @description：SizeOf使用测试
 * @modified By：
 * @version: $
 */
public class SizeOfTest {
    public static void main(String[] args) {
        // RamUsageEstimator 计算对象占用
        System.out.println(RamUsageEstimator.sizeOf(new Object()));
    }
}
