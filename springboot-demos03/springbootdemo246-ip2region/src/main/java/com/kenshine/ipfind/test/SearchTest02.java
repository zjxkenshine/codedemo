package com.kenshine.ipfind.test;

import org.lionsoul.ip2region.xdb.Searcher;

import java.util.concurrent.TimeUnit;

/**
 * @author by kenshine
 * @Classname SearchTest02
 * @Description 缓存VectorIndex索引
 * @Date 2023-08-09 8:31
 * @modified By：
 * @version: 1.0$
 */
public class SearchTest02 {
    public static void main(String[] args) {
            String dbPath = "ip/ip2region.xdb";

            // 1、从 dbPath 中预先加载 VectorIndex 缓存，并且把这个得到的数据作为全局变量，后续反复使用。
            byte[] vIndex;
            try {
                vIndex = Searcher.loadVectorIndexFromFile(dbPath);
            } catch (Exception e) {
                System.out.printf("failed to load vector index from `%s`: %s\n", dbPath, e);
                return;
            }

            // 2、使用全局的 vIndex 创建带 VectorIndex 缓存的查询对象。
            Searcher searcher;
            try {
                searcher = Searcher.newWithVectorIndex(dbPath, vIndex);
            } catch (Exception e) {
                System.out.printf("failed to create vectorIndex cached searcher with `%s`: %s\n", dbPath, e);
                return;
            }
            String ip = "180.101.50.188";
            // 3、查询
            try {
                long sTime = System.nanoTime();
                String region = searcher.search(ip);
                long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
                System.out.printf("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost);
            } catch (Exception e) {
                System.out.printf("failed to search(%s): %s\n", ip, e);
            }

            // 备注：每个线程需要单独创建一个独立的 Searcher 对象，但是都共享全局的制度 vIndex 缓存。

    }
}
