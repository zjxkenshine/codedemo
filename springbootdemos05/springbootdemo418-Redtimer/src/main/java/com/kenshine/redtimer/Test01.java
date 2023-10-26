package com.kenshine.redtimer;

import net.tccn.timer.TimerExecutor;
import net.tccn.timer.TimerTask;
import net.tccn.timer.scheduled.ScheduledCycle;
import net.tccn.timer.scheduled.ScheduledExpres;
import net.tccn.timer.task.Task;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/26 23:58
 * @description：测试1
 * @modified By：
 * @version: $
 */
public class Test01 {
    /**
     * // ScheduledCycle 周期任务定义：
     * //传入数值，单位毫秒
     * ScheduledCycle.of(2000 * 1);
     * // 数值+单位，如：2s 内置转换表示 2秒，如：
     * ScheduledCycle.of("2s"); // 每 2秒 执行执行一次
     * ScheduledCycle.of("2m"); // 每 2分钟 执行执行一次
     * ScheduledCycle.of("2H"); // 每 2小时 执行执行一次
     * ScheduledCycle.of("2d"); // 每 2天 执行执行一次
     *
     * // ScheduledExpres 定义，从左到右空格分割共5位，分别表示：分-时-日-月-周，支持同 Linux中的 crond 时间表达式
     * ScheduledExpres.of("1-40 * * * *"); // 任务每小时的1-40每分钟执行
     */
    public static void main(String[] args) {
        TimerExecutor timer = new TimerExecutor(1);

        //A1 任务每 5s 执行一次
        Task task1 = TimerTask.by("A1", ScheduledCycle.of(1000 * 5), t -> {
            System.out.println(t.getName() + " 执行了");
        });

        //A2 任务每小时的1-40每分钟执行
        Task task2 = TimerTask.by("A2", ScheduledExpres.of("1-40 * * * *"), t -> {
            System.out.println(t.getName() + " 执行了");
            t.setScheduled(ScheduledCycle.of(2000 * 1)); //修改当前任务执行计划
            // t.setComplete(true); //在执行任务的过程中 设置任务状态为[完成]，配合 timerExecutor.remove("taskname") 可很好的使用在系统数据过期检查中
        });
        //添加任务 task1，task2
        timer.add(task1, task2);
        //从任务队列中删除A1任务
        //timer.remove("A1");
    }


}
