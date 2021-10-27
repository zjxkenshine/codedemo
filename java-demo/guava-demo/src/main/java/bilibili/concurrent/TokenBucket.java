package bilibili.concurrent;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 21:54
 * @description：令牌桶
 * @modified By：
 * @version: $
 */
public class TokenBucket {

    private AtomicInteger  phoneNumbers= new AtomicInteger(0);
    //限制
    private final static int LIMIT = 100;
    //每秒10个
    private RateLimiter rateLimiter = RateLimiter.create(10);
    //消费者限制
    private final int saleLimit;

    public TokenBucket(){
        this(LIMIT);
    }

    public TokenBucket(int limit){
        this.saleLimit =limit;
    }
    //购买
    public int buy(){

        Stopwatch started = Stopwatch.createStarted();
        boolean success = rateLimiter.tryAcquire(10, TimeUnit.SECONDS);
        if(success){
            if(phoneNumbers.get() >= saleLimit){
                throw new IllegalStateException("没有产品可销售,请等待");
            }

            int phoneNo = phoneNumbers.getAndIncrement();
            //处理订单
            handleOrder();
            System.out.println(Thread.currentThread()+"抢到了产品" +phoneNo + ",elt="+ started.stop());
            return phoneNo;
        }else {
            started.stop();
            throw new IllegalStateException("没有抢到该产品");
        }
    }

    private void handleOrder(){
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
