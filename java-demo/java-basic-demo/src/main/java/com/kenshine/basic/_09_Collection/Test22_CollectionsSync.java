package com.kenshine.basic._09_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 23:25
 * @description：同步视图
 * @modified By：
 * @version: $
 *
 */
public class Test22_CollectionsSync {
    static List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) throws InterruptedException {
        // 先存放1000个值让iterator有值可以遍历
        for (int i = 0; i < 5; i++) {
            synchronizedList.add(i);
        }
        Thread iteratorThread = new Thread(new IteratorRunnable(synchronizedList));
        //使用 Iterator遍历列表时，Collections.synchronizedList 可能发生错误
        iteratorThread.start();

        TimeUnit.SECONDS.sleep(1);

        Thread modifyThread = new Thread(new ModifySynchronizeRunnable(synchronizedList));
        modifyThread.start();
    }
}

//遍历线程
class IteratorRunnable implements Runnable {
    private List<Integer> list;
    public IteratorRunnable(List<Integer> synchronizeList) {
        this.list = synchronizeList;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (list) {
                for (Integer i : list) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i + ",");
                }
            }
        }
    }
}

//更新线程
class ModifySynchronizeRunnable implements Runnable {
    private List<Integer> list;

    public ModifySynchronizeRunnable(List<Integer> synchronizeList) {
        this.list = synchronizeList;
    }

    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(100);
            System.out.println("modify list container");
        }
    }
}
