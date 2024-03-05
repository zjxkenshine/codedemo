package com.kenshine.easyretry.common.callback;

import com.aizuda.easy.retry.client.core.callback.RetryCompleteCallback;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kenshine
 * 订单重试接口
 */
@Slf4j
public class OrderCompleteCallback implements RetryCompleteCallback {


    /**
    * 重试成功后的回调函数
    * 参数1-场景名称
    * 参数2-执行器名称
    * 参数3-入参信息
    */
    @Override
    public void doSuccessCallback(String sceneName, String executorName, Object[] objects) {
        System.out.println("这是成功的回调方法");
    }

    /**
    * 重试达到最大次数后的回调函数
    * 参数1-场景名称
    * 参数2-执行器名称
    * 参数3-入参信息
    */
    @Override
    public void doMaxRetryCallback(String sceneName, String executorName, Object[] objects) {
        System.out.println("这是失败的回调方法");
    }
}