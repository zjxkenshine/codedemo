package com.kenshine.demo03;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 16:21
 * @description：任务
 * @modified By：
 * @version: $
 *
 *
 * 如果不添加@Async注解,默认是串行执行.
 * 如果只有一个定时任务，这样做肯定没问题，当定时任务增多，如果一个任务卡死，会导致其他任务也无法执行。
 * 当有多个任务的时候,可以使用@Async注解进行异步执行
 *
 * 项目启动后自动开始执行
 */
//@Component
//@EnableScheduling
//@Async
public class AlarmTask {
    /**
     * ixedRate：定义一个按一定频率执行的定时任务。
     *
     * fixedDelay：定义一个按一定频率执行的定时任务，与上面不同的是，改属性可以配合。
     *
     * initialDelay，定义该任务延迟执行时间。
     *
     * cron：通过表达式来配置任务执行时间
     */

    /**默认是fixedDelay,上一次执行完毕时间后执行下一轮*/
    @Scheduled(cron = "0/3 * * * * *")
    public void run1() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"=====>>>>>使用cron  {}"+(System.currentTimeMillis()/1000));
    }

    /**fixedRate:上一次开始执行时间点之后5秒再执行*/
    @Scheduled(fixedRate = 5000)
    public void run2() throws InterruptedException {
        Thread.sleep(6000);
        System.out.println(Thread.currentThread().getName()+"=====>>>>>使用fixedRate  {}"+(System.currentTimeMillis()/1000));
    }

    /**fixedDelay:上一次执行完毕时间点之后5秒再执行*/
    @Scheduled(fixedDelay = 5000)
    public void run3() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println(Thread.currentThread().getName()+"=====>>>>>使用fixedDelay  {}"+(System.currentTimeMillis()/1000));
    }

    /**第一次延迟2秒后执行，之后按fixedDelay的规则每5秒执行一次*/
    @Scheduled(initialDelay = 2000, fixedDelay = 5000)
    public void run4(){
        System.out.println(Thread.currentThread().getName()+"=====>>>>>使用initialDelay  {}"+(System.currentTimeMillis()/1000));
    }


}
