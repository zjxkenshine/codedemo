package com.kenshine.chapter03;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/4 20:49
 * @description：Sleep
 * @modified By：
 * @version: $
 * 调用 sleep 会让当前线程从 Running 进入 Timed Waiting 状态（阻塞）
 * 其它线程可以使用 interrupt 方法打断正在睡眠的线程，那么被打断的线程这时就会抛出 InterruptedException 异常
 * 睡眠结束后的线程未必会立刻得到执行 (需要分配到 cpu 时间片)
 */
@Slf4j
public class Test06_Sleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("线程t1"){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        log.debug("t1 state:{}",t1.getState());
        TimeUnit.SECONDS.sleep(1);
    }
}
