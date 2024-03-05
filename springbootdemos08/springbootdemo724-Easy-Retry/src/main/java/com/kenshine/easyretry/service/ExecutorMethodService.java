package com.kenshine.easyretry.service;

import com.aizuda.easy.retry.client.core.retryer.EasyRetryTemplate;
import com.aizuda.easy.retry.client.core.retryer.RetryTaskTemplateBuilder;
import com.kenshine.easyretry.common.executor.MyExecutorTask;
import com.kenshine.easyretry.model.OrderVo;
import org.springframework.stereotype.Component;

/**
 * @author 手动上报
 */
@Component
public class ExecutorMethodService {
    public void myExecutorMethod(){
        OrderVo orderVo = OrderVo.builder()
            .orderId("123456789")
            .source(1)
            .build();
        EasyRetryTemplate easyRetryTemplate = RetryTaskTemplateBuilder.newBuilder()
            // 手动指定场景名称
            .withScene(MyExecutorTask.SCENE)
            // 指定要执行的任务
            .withExecutorMethod(MyExecutorTask.class)
            // 指定参数
            .withParam(orderVo)
            .build();
        // 执行模板
        easyRetryTemplate.executeRetry();
    }

}