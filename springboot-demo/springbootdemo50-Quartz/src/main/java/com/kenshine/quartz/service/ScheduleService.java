package com.kenshine.quartz.service;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;

import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 16:22
 * @description：定时任务业务
 * @modified By：
 * @version: $
 */
public interface ScheduleService {

    /**
     * 添加定时任务Job
     * @param jobName 任务名
     * @param jobGroup 任务组
     * @param jobClassName 任务类名
     * @param triggerName 触发器名
     * @param triggerGroup 触发器组
     * @param cronExpression 异常
     */
    void addSchedule(String jobName, String jobGroup, String jobClassName, String triggerName, String triggerGroup, String cronExpression);

    /**
     * 暂停定时任务
     * @param jobName 任务名
     * @param jobGroup 任务组
     */
    void pauseSchedule(String jobName, String jobGroup);

    /**
     * 重启定时任务
     * @param jobName 任务名
     * @param jobGroup 任务组
     */
    void resumeSchedule(String jobName, String jobGroup);

    /**
     * 删除定时任务
     * @param jobName 任务名
     * @param jobGroup 任务组
     */
    void deleteSchedule(String jobName, String jobGroup);

    /**
     * 查询所有任务
     * @return
     */
    Set<JobKey> getJobList();

    /**
     * 查询Job详情
     * @return
     */
    JobDetail getJobDetails(String jobName,String jobGroup) throws SchedulerException;


}
