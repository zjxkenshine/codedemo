package com.kenshine.config;

import com.kenshine.demo04.TaskJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 16:31
 * @description：Quartz配置
 * @modified By：
 * @version: $
 */
@Configuration
public class QuartzConfig {


    @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(TaskJob.class)
                .withIdentity("TaskJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        /**
         * CronScheduleBuilder 可接收cron表达式
         */
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                //设置时间周期单位秒
                .withIntervalInSeconds(10)
                .repeatForever();

        /**
         * 触发器绑定 scheduleBuilder和job
         */
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("TaskJob")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
