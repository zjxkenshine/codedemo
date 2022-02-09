package com.kenshine.chapter03;

import com.kenshine.Constants;
import com.kenshine.chapter02.util.FileReader;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/9 10:05
 * @description：
 * @modified By：
 * @version: $
 */
public class Test11_State2 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            FileReader.read(Constants.MP4_FULL_PATH);
            FileReader.read(Constants.MP4_FULL_PATH);
            FileReader.read(Constants.MP4_FULL_PATH);
        }, "t1").start();

        Thread.sleep(1000);
        System.out.println("ok");
    }
}
