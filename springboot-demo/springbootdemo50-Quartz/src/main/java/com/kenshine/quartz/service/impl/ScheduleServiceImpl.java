package com.kenshine.quartz.service.impl;

import com.kenshine.quartz.service.ScheduleService;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.utils.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 16:23
 * @description：定时任务业务实现
 * @modified By：
 * @version: $
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private Scheduler scheduler;

    @Override
    public void addSchedule(String jobName, String jobGroup, String jobClassName, String triggerName, String triggerGroup, String cronExpression) {
        try {
            Class className = Class.forName(jobClassName);
            QuartzJobBean jobBean = (QuartzJobBean) className.newInstance();
            JobDetail jobDetail = JobBuilder.newJob(jobBean.getClass())
                    .withIdentity(jobName, jobGroup)
                    .storeDurably()
                    .build();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerName, triggerGroup)
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                    .build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
        } catch (SchedulerException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pauseSchedule(String jobName, String jobGroup) {
        try {
            scheduler.pauseJob(JobKey.jobKey(jobName, jobGroup));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resumeSchedule(String jobName, String jobGroup) {
        try {
            scheduler.resumeJob(JobKey.jobKey(jobName, jobGroup));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSchedule(String jobName, String jobGroup) {
        try {
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有任务可以
     */
    public Set<JobKey> getJobList(){
        try {
           return scheduler.getJobKeys(GroupMatcher.anyGroup());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 查询Job详情
     */
    public JobDetail getJobDetails(String jobName,String jobGroup) throws SchedulerException {
       return scheduler.getJobDetail(new JobKey(jobName,jobGroup));
    }


}
