package com.kenshine.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 16:27
 * @description：定时任务
 * @modified By：
 * @version: $
 */
public class CronJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(CronJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("执行cron定时任务{}", LocalDateTime.now());
    }


}
