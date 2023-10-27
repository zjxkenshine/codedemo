package com.kenshine.rafiki;

import org.pinae.rafiki.job.Job;
import org.pinae.rafiki.job.JobException;
import org.pinae.rafiki.task.Task;
import org.pinae.rafiki.task.TaskContainer;
import org.pinae.rafiki.task.TaskException;
import org.pinae.rafiki.trigger.TriggerException;
import org.pinae.rafiki.trigger.impl.CronTrigger;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 测试
 * @Date 2023-10-27 12:00
 * @modified By：
 * @version: 1.0$
 */
public class Test {

    public static void main(String[] args) throws TaskException, TriggerException {
        Task task = new Task();
        Job job = new Job() {
            @Override
            public String getName() {
                return "DelayJob";
            }

            @Override
            public boolean execute(){
                System.out.println(getName());
                System.out.println("Now is : " + System.currentTimeMillis());
                return true;
            }
        };

        // 设置任务与触发器
        task.setName("HelloJob");
        task.setJob(job);
        // 每分钟的0-30秒每5秒执行一次
        task.setTrigger(new CronTrigger("0-30/5 * * * * * *"));
        // 启动
        TaskContainer container = new TaskContainer();
        container.addTask(task);
        container.start();
    }
}
