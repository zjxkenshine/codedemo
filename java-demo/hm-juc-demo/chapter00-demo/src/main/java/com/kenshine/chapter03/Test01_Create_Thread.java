package com.kenshine.chapter03;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/1 10:55
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
public class Test01_Create_Thread {
    public static void main(String[] args) {
        // 匿名内部类方式创建 Thread
        Thread t = new Thread("t1") {
            @Override
            public void run() {
                log.debug("子线程 running");
            }
        };
        t.setName("线程t1");
        t.start();
        log.debug("主线程 running");
    }
}
