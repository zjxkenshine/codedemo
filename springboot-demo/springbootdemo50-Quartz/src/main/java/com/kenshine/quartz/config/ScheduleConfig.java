package com.kenshine.quartz.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 16:21
 * @description：定时任务
 * @modified By：
 * @version: $
 */
@Configuration
public class ScheduleConfig {
    @Resource
    private SchedulerFactoryBean schedulerFactoryBean;

    @Bean
    public Scheduler scheduler() {
        return schedulerFactoryBean.getScheduler();
    }

}
