package bilibili.concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 7:13
 * @description：RateLimit实现 漏桶算法
 * @modified By：
 * @version: $
 */
public class Bucket {
    private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<>();

    private final static int BUCKET_LIMIT = 1000;

    private final RateLimiter rateLimiter = RateLimiter.create(10);

    private final Monitor offerMonitor = new Monitor();
    private final Monitor pollMonitor = new Monitor();


    /**
     * 提交
     * @param data
     */
    public void submit(Integer data){
        //加锁
        if(offerMonitor.enterIf(offerMonitor.newGuard(()->container.size()<BUCKET_LIMIT))){
            try {
                container.offer(data);
                System.out.println(Thread.currentThread() + " submit data " + data + " ,size = "+ container.size());
            }finally {
                //操作完解锁
                offerMonitor.leave();
            }
        }else{
            throw new IllegalStateException("The bucket is full");
        }
    }

    public void takeThenConsume(Consumer<Integer> consumer){
        if(pollMonitor.enterIf(pollMonitor.newGuard(()->!container.isEmpty()))){
            try {
                System.out.println(Thread.currentThread() + "wating" + rateLimiter.acquire());
                consumer.accept(container.poll());
            }finally {
                pollMonitor.leave();
            }
        }
    }


}
