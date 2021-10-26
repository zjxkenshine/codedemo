package bilibili.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 0:04
 * @description：RateLimit示例 限流
 * @modified By：
 * @version: $
 *
 */
public class RateLimitExample {
    /**
     * 一秒钟允许有多少操作 0.5表示2秒进行一次操作
     */
    public final static RateLimiter limiter = RateLimiter.create(0.5);

    /**
     * seamaphore 实现限流
     */
    public final static Semaphore semaphore = new Semaphore(3);


    /**
     * juc semaphore
     * @param args
     */

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
//        IntStream.range(0,10).forEach(i->{
//                service.submit(RateLimitExample::testLimiter);
//        });

        IntStream.range(0,10).forEach(i->{
            service.submit(RateLimitExample::testSemaphore);
        });

    }

    private static void testLimiter(){
        System.out.println(Thread.currentThread()+" waiting "+limiter.acquire());
    }


    /**
     * Semaphore实现限流
     */
    private static void testSemaphore(){
        try{
            semaphore.acquire();
            System.out.println(Thread.currentThread()+" semaphore 正在执行 ");
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }


}
