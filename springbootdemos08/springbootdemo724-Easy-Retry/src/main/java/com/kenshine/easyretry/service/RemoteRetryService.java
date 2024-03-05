package com.kenshine.easyretry.service;

import com.aizuda.easy.retry.client.core.annotation.Retryable;
import com.aizuda.easy.retry.client.core.retryer.RetryType;
import com.kenshine.easyretry.common.callback.OrderCompleteCallback;
import com.kenshine.easyretry.common.idgen.OrderIdempotentIdGenerate;
import com.kenshine.easyretry.common.retrymethod.OrderRetryMethod;
import com.kenshine.easyretry.model.OrderVo;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 远程重试
 * @author kenshine
 */
@Component
public class RemoteRetryService {
    /**
     * 远程上报重试
     */
    @Retryable(scene = "remoteRetry",retryStrategy = RetryType.ONLY_REMOTE)
    public void remoteRetry(){
        System.out.println("远程重试方法启动");
        double i = 1 / 0;
    }

    /**
     * IdGenerate 自定义的幂等Id
     * 使用自定义的幂等Id生成类 OrderIdempotentIdGenerate
     */
    @Retryable(scene = "remoteRetryWithIdempotentId",retryStrategy = RetryType.ONLY_REMOTE,
            idempotentId = OrderIdempotentIdGenerate.class)
    public boolean remoteRetryWithIdempotentId(OrderVo orderVo){
        double i = 1 / 0;
        return true;
    }

    /**
     * Callback 回调方法
     */
    @Retryable(scene = "remoteRetryWithCompleteCallback",retryStrategy = RetryType.LOCAL_REMOTE,
            retryCompleteCallback = OrderCompleteCallback.class)
    public boolean remoteRetryWithCompleteCallback(OrderVo orderVo){
        Random random = new Random();
        // 生成一个随机数，范围为0到1之间
        double probability = random.nextDouble();
        // 判断随机数是否小于等于0.5，即50%的概率
        if (probability <= 0.5) {
            // 生成的结果在50%的概率下执行这里的逻辑
            throw new NullPointerException();
        }
        return true;
    }

    /**
     * RetryMethod 自定义重试函数入口
     */
    @Retryable(scene = "remoteRetryWithRetryMethod", retryStrategy = RetryType.ONLY_REMOTE,
            retryMethod = OrderRetryMethod.class)
    public void remoteRetryWithRetryMethod(OrderVo orderVo){
        throw new NullPointerException();
    }

    /**
     * bizNo 标注业务订单号
     */
    @Retryable(scene = "remoteRetryWithBizNo",retryStrategy = RetryType.ONLY_REMOTE,bizNo = "orderVo.orderId")
    public void remoteRetryWithBizNo(OrderVo orderVo){
        throw new NullPointerException();
    }
}