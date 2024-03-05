package com.kenshine.easyretry.common.retrymethod;

import com.aizuda.easy.retry.client.core.strategy.ExecutorMethod;
import com.kenshine.easyretry.model.OrderVo;
import org.springframework.stereotype.Component;

/**
 * 自定义重试函数入口
 * @author Administrator
 */
@Component
public class OrderRetryMethod implements ExecutorMethod {
    @Override
    public Object doExecute(Object params) {
        // 将特定类型的 Object 对象指定为 Object[]
        Object[] args = (Object[]) params;
        OrderVo orderVo = (OrderVo) args[0];
        //log.info("进入自定义的回调方法,参数信息是{}", JSONUtil.toJsonStr(orderVo));
        System.out.println("进入自定义重试函数");
        System.out.println(orderVo);
        throw new ArithmeticException();
    }
}