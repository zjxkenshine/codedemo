package com.kenshine.quasar.demo01;

import co.paralleluniverse.fibers.Fiber;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/15 14:08
 * @description：测试2
 * @modified By：
 * @version: $
 */
public class test02 {

    public static void main(String[] args) {
        new Fiber<>(() -> {
            System.out.println("Hello Fiber");
            return null;
        }).start();
    }

}
