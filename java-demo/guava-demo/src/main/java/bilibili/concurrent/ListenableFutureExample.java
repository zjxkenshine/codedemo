package bilibili.concurrent;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 22:26
 * @description：ListenableFuture示例
 * @modified By：
 * @version: $
 *
 * ListenableFuture
 * 与java8 CompletableFuture作用相同
 */
public class ListenableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

//        Future<?> future = service.submit(()->{
//           try {
//               TimeUnit.SECONDS.sleep(5);
//           }catch (InterruptedException e){
//                e.printStackTrace();
//           }
//           return 10;
//        });
//
//        Object result =  future.get();
//        System.out.println(result);

        ListeningExecutorService listeningExecutorService =MoreExecutors.listeningDecorator(service);
        ListenableFuture<Integer> future = listeningExecutorService.submit(()->{
           try {
               TimeUnit.SECONDS.sleep(5);
           }catch (InterruptedException e){
                e.printStackTrace();
           }
           return 10;
        });

        //无返回值方式
        //future.addListener(()-> System.out.println("任务结束了"),service);

        Futures.addCallback(future,new MyCallBack(),service);
        System.out.println("===================================================");


        /**
         * CompletableFuture实现
         */
        CompletableFuture<?> cfuture = CompletableFuture.supplyAsync(()->{
           try {
               TimeUnit.SECONDS.sleep(5);
           }catch (InterruptedException e){
                e.printStackTrace();
           }
           return 100;
        },service);
        cfuture.whenComplete((v,t)-> System.out.println("结果2是:"+v));

    }

    static class MyCallBack implements FutureCallback<Integer>{

        @Override
        public void onSuccess(@Nullable Integer integer) {
            System.out.println("执行结束了"+integer);
        }

        @Override
        public void onFailure(Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
