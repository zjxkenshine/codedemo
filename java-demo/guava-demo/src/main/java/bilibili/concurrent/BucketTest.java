package bilibili.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 7:26
 * @description：限流桶测试
 * @modified By：
 * @version: $
 */
public class BucketTest {

    public static void main(String[] args) {
        final Bucket bucket =  new Bucket();
        final AtomicInteger DATA_CREATOR = new AtomicInteger(0);

        /** 五个线程不断执行
         *  一秒有25个submit
         *  Bucket只处理10个
         * */
        IntStream.range(0,5).forEach(i->{
            new Thread(()->{
                for(;;){
                    int data = DATA_CREATOR.getAndIncrement();
                    bucket.submit(data);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200L);
                    } catch (Exception e) {
                        if(e instanceof IllegalStateException){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }).start();
        });

        /**
         * 从桶中获取并执行操作
         * 预期比 5:2
         */
        IntStream.range(0,5).forEach(i->{
            new Thread(()->{
                for(;;){
                    bucket.takeThenConsume(x-> System.out.println(Thread.currentThread() + "W" + x));
                }
            }).start();
        });
    }

}
