package com.kenshine.objenesis.demo;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisBase;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 14:26
 * @description：自定义策略
 * @modified By：
 * @version: $
 */
public class test03 {
    public static void main(String[] args) {
        // Directly
        Objenesis o = new ObjenesisBase(new Sun14Strategy());
    }

    // Or inside your Objenesis own implementation
    class ObjenesisSun14 extends ObjenesisBase {
        public ObjenesisSun14() {
            super(new Sun14Strategy());
        }
    }
}
