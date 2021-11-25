package com.kenshine.affinity.test;

import net.openhft.affinity.AffinityLock;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/25 10:00
 * @description：在单个cpu核心上运行
 * @modified By：
 * @version: $
 */
public class test01 {
    public static void main(String[] args) {
        /**
         * 在需要亲和的代码上加上acquireLock即可，它会自动分配一个空闲核心
         * acquireLock中可以用数字指定一个cpu
         */
        try (AffinityLock al = AffinityLock.acquireLock(5)) {
            // do some work while locked to a CPU.
            System.out.println(al.cpuId());
            while(true) {}
        }
    }
}
