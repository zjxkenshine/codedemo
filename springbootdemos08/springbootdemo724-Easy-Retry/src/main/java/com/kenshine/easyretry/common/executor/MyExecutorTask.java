package com.kenshine.easyretry.common.executor;

import com.aizuda.easy.retry.client.core.annotation.ExecutorMethodRegister;
import com.aizuda.easy.retry.client.core.strategy.ExecutorMethod;
import com.aizuda.easy.retry.common.core.util.JsonUtil;
import com.kenshine.easyretry.model.OrderVo;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kenshine
 * ExecutorMethodRegister 手动上报注册
 */
@ExecutorMethodRegister(scene = MyExecutorTask.SCENE)
@Slf4j
public class MyExecutorTask implements ExecutorMethod {
    /**
     * 自定义场景值
     */
    public final static String SCENE = "myExecutorMethod";

    @Override
    public Object doExecute(Object params) {
        // 将特定类型的 Object 对象指定为 Object[]
        Object[] args = (Object[]) params;
        OrderVo orderVo = (OrderVo) args[0];
        log.info("进入手动重试方法,参数信息是{}", JsonUtil.toJson(orderVo));
        return true;
    }
}