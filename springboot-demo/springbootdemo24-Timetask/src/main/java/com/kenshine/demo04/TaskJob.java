package com.kenshine.demo04;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 16:30
 * @description：任务类
 * @modified By：
 * @version: $
 */
public class TaskJob extends QuartzJobBean {

    /**
     * 执行定时任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz task "+new Date());
    }

}
