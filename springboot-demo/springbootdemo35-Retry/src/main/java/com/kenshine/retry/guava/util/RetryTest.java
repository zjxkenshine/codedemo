package com.kenshine.retry.guava.util;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 17:44
 * @description：guava 重试工具类
 * @modified By：
 * @version: $
 */
public class RetryTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Boolean shopping() throws Exception {
        //定义重试机制
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                //retryIf 重试条件 异常相关
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfException(Predicates.equalTo(new Exception()))
                //结果为false重试
                .retryIfResult(Predicates.equalTo(false))

                //等待策略：每次请求间隔1s
                //fixedWait 固定X秒后重试
                //noWait不等时间直接重试
                //incrementingWait 第一个参数为第一次重试时间，后面会通过设置间隔递增秒数重试
                //randomWait 随机等待设置范围内的时间重试
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))

                //停止策略 : 尝试请求6次
                .withStopStrategy(StopStrategies.stopAfterAttempt(6))

                //重试监听器
                .withRetryListener(new MyRetryListener())
                .withRetryListener(new MyRetryListener2())
                .build();


        //定义请求实现
        Callable<Boolean> callable = new Callable<Boolean>() {
            int times = 1;

            @Override
            public Boolean call() throws Exception {
                log.info("重试调用={}", times);
                times++;
                //业务方法
                return placeOrder();
            }
        };

        //利用重试器调用请求
        return retryer.call(callable);
    }


    /**
     * 下单业务方法 模拟
     *
     * @return
     */
    public Boolean placeOrder() {
        int number = new Random().nextInt(11);
        System.out.println("number:"+number);
        if (7 < number) {
            //模拟下单成功
            log.info("下单成功");
            return true;
        }
        log.info("下单失败");
        return false;
    }


    private static class MyRetryListener implements RetryListener {
        @Override
        public <V> void onRetry(Attempt<V> attempt) {
            System.out.println("回调监听器 一，当前是第："+attempt.getAttemptNumber()+ "次执行");

        }
    }

    private static class MyRetryListener2 implements RetryListener {
        @Override
        public <V> void onRetry(Attempt<V> attempt) {
            System.out.println("回调监听器 二：记录日志"+attempt.getAttemptNumber());
        }
    }

    public static void main(String[] args) throws Exception {
        RetryTest retryTest = new RetryTest();
        Boolean result = retryTest.shopping();
        System.out.println(result);
    }
}
