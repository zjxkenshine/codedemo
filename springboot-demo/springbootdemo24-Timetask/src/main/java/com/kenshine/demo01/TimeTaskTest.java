package com.kenshine.demo01;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 15:50
 * @description：TimeTask测试
 * @modified By：
 * @version: $
 *
 * 缺陷
 * 首先Timer对调度的支持是基于绝对时间的，而不是相对时间，所以它对系统时间的改变非常敏感。
 * 其次Timer线程是不会捕获异常的，如果TimerTask抛出的了未检查异常则会导致Timer线程终止。
 * 第三Timer也不会重新恢复线程的执行，它会错误的认为整个Timer线程都会取消。
 * 同时，已经被安排单尚未执行的TimerTask也不会再执行了，新的任务也不能被调度
 */
public class TimeTaskTest {

    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task  run:"+ new Date());
            }
        };

        Timer timer = new Timer();
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。这里是每3秒执行一次
        timer.schedule(timerTask,10,3000);

    }

}
