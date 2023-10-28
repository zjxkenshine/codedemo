package com.kenshine.failsafe;

import dev.failsafe.*;
import dev.failsafe.okhttp.FailsafeCall;
import okhttp3.Response;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.net.ConnectException;
import java.time.Duration;

/**
 * @author by kenshine
 * @Classname FailsafeTest
 * @Description 测试
 * @Date 2023-10-28 13:59
 * @modified By：
 * @version: 1.0$
 */
public class FailsafeTest {
    /**
     * Retry策略
     *
     * // withMaxAttempts(-1) 关闭最大重试限制
     * // withMaxDuration(Duration.ofMinutes(5)); 最大重复时间
     * // withDelay(Duration.ofSeconds(1)); 延迟    .withBackoff(1, 30, ChronoUnit.SECONDS); 指数级延迟
     * // .withJitter 抖动延迟
     * // .abortWhen(true)，.abortOn(NoRouteToHostException.class)，.abortIf(result -> result == true) 中止条件
     * // .handle(ConnectException.class) .handleResult(null);  失败处理
     *
     * // .onFailedAttempt(e -> log.error("Connection attempt failed", e.getLastException()))  监听器
     * //  .onRetry(e -> log.warn("Failure #{}. Retrying.", e.getAttemptCount()));        监听器
     * // .onRetriesExceeded(e -> log.warn("Failed to connect. Max retries exceeded."))   执行最大时监听
     * // onRetryScheduled(e -> log.info("Connection retry scheduled {}.", e.getException())); 当计划在配置的延迟之后尝试异步重试时
     * // onAbort(e -> log.warn("Connection aborted due to {}.", e.getException()));   抛出监听
     */
    @Test
    public void test01(){
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder()
                .handle(ConnectException.class)
                .withDelay(Duration.ofSeconds(1))
                // 最大重试3次
                .withMaxRetries(3)
                .build();


    }

    /**
     * CircuitBreaker 断路器策略
     *
     // .withFailureThreshold(5); 失败5次后断开
     // .withFailureThreshold(3, Duration.ofMinutes(1)); 一段时间失败多少次断开
     // withSuccessThreshold(5);断路器可以配置为在多次审判执行成功时再次关闭
     //.handle(ConnectException.class) .handleResult(null); 处理结果
     //.onOpen(e -> log.info("The circuit breaker was opened"))  监听器
     //  .onClose(e -> log.info("The circuit breaker was closed"))
     //  .onHalfOpen(e -> log.info("The circuit breaker was half-opened"));
     */
    @Test
    public void test02(){
        CircuitBreaker<Object> breaker = CircuitBreaker.builder()
                .handle(ConnectException.class)
                .withFailureThreshold(5)
                .withDelay(Duration.ofMinutes(1))
                .withSuccessThreshold(2)
                .build();


        breaker.open();
        breaker.halfOpen();
        breaker.close();

        // 使用
        if (breaker.tryAcquirePermit()) {
            try {
                // doSomething();
                breaker.recordSuccess();
            } catch (Exception e) {
                breaker.recordException(e);
            }
        }
    }

    /**
     * Rate Limiter 限流策略
     *
     */
    @Test
    public void test03(){
        // 每秒100次
        RateLimiter<Object> limiter = RateLimiter.smoothBuilder(100, Duration.ofSeconds(1)).build();
        // 每10毫秒执行一次
        RateLimiter<Object> limiter1 = RateLimiter.smoothBuilder(Duration.ofMillis(10)).build();
        // 允许在单个时间段内执行的最大数量 每秒10次
        RateLimiter<Object> limiter3 = RateLimiter.burstyBuilder(10, Duration.ofSeconds(1)).build();
        //.withMaxWaitTime(Duration.ofSeconds(1)); 等待最多1秒

        // 使用
        if (limiter.tryAcquirePermit()) {
            //doSomething();
            System.out.println("执行");
        }
    }

    /**
     * timeout 重试
     * .onFailure(e -> log.error("Connection attempt timed out", e.getException()));
     * .onSuccess(e -> log.info("Execution completed on time"));
     */
    @Test
    public void test04(){
        // 10s超时
        Timeout<Object> timeout = Timeout.of(Duration.ofSeconds(10));
        //
        Timeout<Object> timeout1 = Timeout.builder(Duration.ofSeconds(10)).withInterrupt().build();
        // 测试
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder()
                .handle(ConnectException.class).build();
        // 超时取消重试
        Failsafe.with(timeout).compose(retryPolicy).run(this::connect);
        // 超时的发生不会自动取消任何外部重试
        Failsafe.with(retryPolicy).compose(timeout).run(this::connect);
    }


    /**
     * Bulkhead 隔离 限制并发执行，作为防止系统过载的一种方式
     *
     */
    @Test
    public void test05(){
        // 10次并发执行
        Bulkhead<Object> bulkhead = Bulkhead.of(10);
        // 等待1秒后开始执行
        Bulkhead<Object> bulkhead1 = Bulkhead.builder(10)
                .withMaxWaitTime(Duration.ofSeconds(1))
                .build();
        // 使用方式
        if (bulkhead.tryAcquirePermit()) {
            try {
                // doSomething();
            } finally {
                bulkhead.releasePermit();
            }
        }
    }

    /**
     *Fallback 回调，执行失败时提供替代结果
     *
     * 配置为只处理某些结果或异常的:
     * builder
     *   .handle(ConnectException.class)
     *   .handleResult(null);
     *
     * 事件监听：
     *   builder.onFailedAttempt(e -> log.error("Connection failed", e.getException()))
     */
    @Test
    public void test06(){
        Fallback<Object> fallback = Fallback.of("error");
        // 抛出自定义异常
        Fallback<Object> fallback1 = Fallback.ofException(e -> new CustomException(e));
        //从备份资源中计算另一个结果
        Fallback<Object> fallback2 = Fallback.of(this::connectToBackup);
        // 配置为异步
        Fallback<Object> fallback3 = Fallback.builder(this::blockingCall).withAsync().build();
    }



    private void connect() throws InterruptedException {
        Thread.sleep(1000);
    }

    private String connectToBackup() throws InterruptedException {
        Thread.sleep(1000);
        return "kenshine";
    }

    private Object blockingCall() throws InterruptedException {
        Thread.sleep(1000);
        return "kenshine";
    }


}
