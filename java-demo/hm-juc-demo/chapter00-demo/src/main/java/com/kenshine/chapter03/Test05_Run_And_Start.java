package com.kenshine.chapter03;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/4 20:40
 * @description：run方法测试
 * @modified By：
 * @version: $
 */
@Slf4j
public class Test05_Run_And_Start {
    public static void main(String[] args) {
        Thread t1 = new Thread("线程t1"){
            @Override
            public void run(){
                log.debug("running...");
            }
        };

        // run方法由主线程来执行，不能起到异步效果
        t1.run();
        // start 方法由线程执行
        t1.start();
    }
}
