package com.kenshine.easyretry.job;

import com.aizuda.easy.retry.client.job.core.dto.JobArgs;
import com.aizuda.easy.retry.client.job.core.executor.AbstractJobExecutor;
import com.aizuda.easy.retry.client.model.ExecuteResult;
import org.springframework.stereotype.Component;

/**
 * 通过继承执行
 * @author Administrator
 */
@Component
public class TestClassJobExecutor extends AbstractJobExecutor {

    @Override
    protected ExecuteResult doJobExecute(JobArgs jobArgs) {
        return ExecuteResult.success("TestJobExecutor测试成功");
    }
}