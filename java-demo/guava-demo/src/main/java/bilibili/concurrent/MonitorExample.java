package bilibili.concurrent;

import com.google.common.util.concurrent.Monitor;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 23:05
 * @description：Mointor使用测试
 * @modified By：
 * @version: $
 *
 * Mointor监视器测试
 *
 * Synchronized实现生产者消费者
 * LockCondition实现生产者消费者
 * Monitor实现生产者消费者
 *
 */
public class MonitorExample {


    public static void main(String[] args) {
        //final Synchronized sync = new Synchronized();
        //final LockCondition sync = new LockCondition();

        final MonitorGuard sync = new MonitorGuard();
        final AtomicInteger COUNTER = new AtomicInteger(0);

        /**
         * 生产者线程
         */
        for(int i=0;i<=3;i++){
            new Thread(()->{
                int data = COUNTER.getAndIncrement();
                System.out.println(Thread.currentThread() + "offer" + data);
                sync.offer(data);
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        /**
         * 消费者线程
         */
        for(int i=0;i<=2;i++){
            new Thread(()->{
                int data = sync.take();
                System.out.println(Thread.currentThread() + "take" + data);
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }

    /**
     * guava Monitor 生产者消费者
     */
    static class MonitorGuard{
        private final LinkedList<Integer> queue = new LinkedList<>();
        private final int MAX = 10;

        private final Monitor monitor = new Monitor();

        private final Monitor.Guard CAN_OFFER = monitor.newGuard(()->queue.size()<MAX);
        private final Monitor.Guard CAN_TAKE = monitor.newGuard(()->!queue.isEmpty());

        public void offer(int value){
            try{
                monitor.enterWhen(CAN_OFFER);
                queue.add(value);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                monitor.leave();
            }
        }

        public int take(){
            try{
                monitor.enterWhen(CAN_TAKE);
                return queue.removeFirst();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }finally {
                monitor.leave();
            }
        }

    }


    /**
     * Synchroinzed实现生产者消费者
     */
    static class Synchronized{
        private final LinkedList<Integer> queue = new LinkedList<>();
        private final int MAX = 10;

        /**
         * 生产者
         * @param value
         */
        public void offer(int value){
            synchronized (queue){
                while (queue.size() >= MAX){
                    try {
                        queue.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                queue.addLast(value);
                queue.notifyAll();
            }

        }


        /**
         * 消费者方法
         */
        public int take(){
            synchronized (queue){
                while (queue.isEmpty()){
                    try {
                        queue.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Integer value = queue.removeFirst();
                queue.notifyAll();
                return value;
            }
        }
    }


    /**
     * Condition实现 生产者消费者
     */
    static class LockCondition{
        private final ReentrantLock lock  = new ReentrantLock();
        private final Condition FULL_CONDITION = lock.newCondition();
        private final Condition EMPTY_CONDITION = lock.newCondition();
        private final LinkedList<Integer> queue = new LinkedList<>();
        private final int MAX = 10;


        //生产者方法
        public void offer(int value){
            lock.lock();
            try{
                while (queue.size() >= MAX){
                    FULL_CONDITION.await();
                    queue.addLast(value);
                }
                queue.addLast(value);
                FULL_CONDITION.signalAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

        public int take(){
            lock.lock();
            try {
                while (queue.isEmpty()){
                    try {
                        queue.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Integer value = queue.removeFirst();
                EMPTY_CONDITION.signalAll();
                return value;
            } finally {
                lock.unlock();
            }

        }


    }

}
