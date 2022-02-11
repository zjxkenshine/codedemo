package com.kenshine.chapter06;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 21:12
 * @description：原子字段更新器
 * @modified By：
 * @version: $
 */
public class Test08_AtomicFieldUpdater {
    // 必须要与volatile一起用
    private volatile int field;

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<Test08_AtomicFieldUpdater> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Test08_AtomicFieldUpdater.class, "field");
        Test08_AtomicFieldUpdater updater = new Test08_AtomicFieldUpdater();
        fieldUpdater.compareAndSet(updater, 0, 10);
        // 修改成功 field = 10
        System.out.println(updater.field);
        // 修改成功 field = 20
        fieldUpdater.compareAndSet(updater, 10, 20);
        System.out.println(updater.field);
        // 修改失败 field = 20
        fieldUpdater.compareAndSet(updater, 10, 30);
        System.out.println(updater.field);
    }
}
