package com.kenshine.retry.spring.service.impl;

import com.kenshine.retry.spring.service.TestRetryService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 17:29
 * @description：重试逻辑实现
 * @modified By：
 * @version: $
 *
 */
@Service
public class TestRetryServiceImpl implements TestRetryService {

    /**
     * 重试测试
     * @param code
     * @return
     * @throws Exception
     *
     * //Retryable注解
     * - value:遇到Exception触发
     * - maxAttempts:重试次数
     * - delay：重试时间，毫秒
     * - multiplier：倍数，第一次100毫秒，第二次100*1.5
     * - maxDelay：重试次数之间的最大时间间隔,默认为0,即忽略,如果小于delay的设置,则默认为30000L
     */
    @Override
    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public int dignifiedTest(int code) throws Exception{
        System.out.println("dignifiedTest被调用,时间："+ LocalTime.now());
        if (code==0){
            throw new Exception("情况不对头！");
        }
        System.out.println("dignifiedTest被调用,情况对头了！");

        return 200;
    }

    /**
     * 回调方法
     * @param e
     * @return
     * 注意：该回调方法与重试方法写在同一个实现类里面
     *
     * //@Recover注解
     * 标记当期方法为回调方法
     * 抛出这个Exception e通知触发这个回调方法
     */
    @Recover
    public int recover(Exception e){
        System.out.println("回调方法执行！！！！");
        //记日志到数据库 或者调用其余的方法
        return 400;
    }


}
