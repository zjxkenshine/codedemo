package com.kenshine.jctools;

import org.jctools.maps.NonBlockingHashMap;
import org.jctools.maps.NonBlockingHashMapLong;
import org.jctools.maps.NonBlockingHashSet;
import org.jctools.maps.NonBlockingIdentityHashMap;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author by kenshine
 * @Classname TestMap
 * @Description 非阻塞Map
 * @Date 2023-11-16 8:44
 * @modified By：
 * @version: 1.0$
 */
public class TestMap {
    ExecutorService pools = new ThreadPoolExecutor(3,
            5,
            8,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(6),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());


    /**
     * NonBlockingHashMap 非阻塞hashmap
     */
    @Test
    public void testNonBlockingHashMap() throws InterruptedException {
        NonBlockingHashMap<String,String> nonBlockingHashMap=new NonBlockingHashMap<>();
        pools.execute(()->{nonBlockingHashMap.put("name","kenshine");});
        pools.execute(()->{nonBlockingHashMap.put("age","18");});
        Thread.sleep(500);
        System.out.println(nonBlockingHashMap.get("name"));
        System.out.println(nonBlockingHashMap.get("age"));
    }

    /**
     * NonBlockingHashMapLong
     */
    @Test
    public void testNonBlockingHashMapLong() throws InterruptedException {
        NonBlockingHashMapLong<String> nonBlockingHashMapLong=new NonBlockingHashMapLong<>();
        pools.execute(()->{nonBlockingHashMapLong.put(1,"kenshine");});
        pools.execute(()->{nonBlockingHashMapLong.put(2,"18");});
        Thread.sleep(500);
        System.out.println(nonBlockingHashMapLong.get(1));
        System.out.println(nonBlockingHashMapLong.get(2));
    }

    /**
     * NonBlockingHashSet
     */
    @Test
    public void testNonBlockingHashSet() throws InterruptedException {
        NonBlockingHashSet<String> nonBlockingHashSet=new NonBlockingHashSet<>();
        pools.execute(()->{nonBlockingHashSet.add("kenshine");});
        pools.execute(()->{nonBlockingHashSet.add("lin");});
        pools.execute(()->{nonBlockingHashSet.add("pig");});
        System.out.println(nonBlockingHashSet.toString());
    }

    /**
     * NonBlockingIdentityHashMap
     */
    @Test
    public void testNonBlockingIdentityHashMap() throws InterruptedException {
        NonBlockingIdentityHashMap<String,String> nonBlockingHashMap= new NonBlockingIdentityHashMap<>();
        pools.execute(()->{nonBlockingHashMap.put("name","kenshine");});
        pools.execute(()->{nonBlockingHashMap.put("age","18");});
        //Thread.sleep(500);
        System.out.println(nonBlockingHashMap.get("name"));
        System.out.println(nonBlockingHashMap.get("age"));
    }


}
