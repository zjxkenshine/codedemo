package com.kenshine.twoparse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/4 22:35
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
public class TwoParseTermination {
    private Thread monitor;

    // 启动线程
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread thread = Thread.currentThread();
                if(thread.isInterrupted()) { // 调用 isInterrupted 不会清除标记
                    log.info("料理后事 ...");
                    break;
                } else {
                    try {
                        Thread.sleep(1000);
                        log.info("执行监控的功能 ...");
                    } catch (InterruptedException e) {
                        log.info("设置打断标记 ...");
                        thread.interrupt();
                        e.printStackTrace();
                    }
                }
            }
        }, "monitor");
        monitor.start();
    }

    // 终止线程
    public void stop() {
        monitor.interrupt();
    }
}
