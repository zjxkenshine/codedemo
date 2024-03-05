package com.kenshine.easyretry.job;

import com.aizuda.easy.retry.client.job.core.annotation.JobExecutor;
import com.aizuda.easy.retry.client.job.core.dto.JobArgs;
import com.aizuda.easy.retry.client.model.ExecuteResult;
import org.springframework.stereotype.Component;

/**
 * @author kenshine
 * @JobExecutor 注解作用于类
 */
@Component
@JobExecutor(name = "testJobExecutor")
public class TestAnnoJobExecutor {

    public ExecuteResult jobExecute(JobArgs jobArgs) {
        return ExecuteResult.success("测试成功");
    }

    /**
     * @JobExecutor 注解作用于方法
     */
    @JobExecutor(name = "testJobExecutor")
    public ExecuteResult jobExecute1(JobArgs jobArgs) {
        return ExecuteResult.success("测试成功");
    }

}