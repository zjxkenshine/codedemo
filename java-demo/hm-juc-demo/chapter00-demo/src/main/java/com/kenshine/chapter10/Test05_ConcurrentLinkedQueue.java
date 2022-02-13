package com.kenshine.chapter10;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 19:18
 * @description： ConcurrentLinkedQueue 使用示例
 * @modified By：
 * @version: $
 * offer(E e) 将指定元素插入此队列的尾部。
 * poll() 获取并移除此队列的头，如果此队列为空，则返回 null。
 * peek() 获取但不移除此队列的头；如果此队列为空，则返回 null
 * remove(Object o) 从队列中移除指定元素的单个实例（如果存在）
 * size() 返回此队列中的元素数量
 * contains(Object o) 如果此队列包含指定元素，则返回 true
 */
public class Test05_ConcurrentLinkedQueue{
    @Test
    public void test01(){
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        // poll
        queue.offer("哈哈哈");
        System.out.println("offer后，队列是否空？" + queue.isEmpty());
        System.out.println("从队列中poll：" + queue.poll());
        System.out.println("pool后，队列是否空？" + queue.isEmpty());

        // peek
        queue.offer("哈哈哈");
        System.out.println("offer后，队列是否空？" + queue.isEmpty());
        System.out.println("从队列中peek：" + queue.peek());
        System.out.println("从队列中peek：" + queue.peek());
        System.out.println("从队列中peek：" + queue.peek());
        System.out.println("pool后，队列是否空？" + queue.isEmpty());

        // remove
        queue.offer("哈哈哈");
        System.out.println("offer后，队列是否空？" + queue.isEmpty());
        System.out.println("从队列中remove已存在元素 ：" + queue.remove("哈哈哈"));
        System.out.println("从队列中remove不存在元素：" + queue.remove("123"));
        System.out.println("remove后，队列是否空？" + queue.isEmpty());
    }

    // 生产者消费者
    @Test
    public void test02() throws InterruptedException {
        int peopleNum = 10000;//吃饭人数
        int tableNum = 10;//饭桌数量

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        CountDownLatch count = new CountDownLatch(tableNum);//计数器

        //将吃饭人数放入队列（吃饭的人进行排队）
        for(int i=1;i<=peopleNum;i++){
            queue.offer("消费者_" + i);
        }
        //执行10个线程从队列取出元素（10个桌子开始供饭）
        System.out.println("-----------------------------------开饭了-----------------------------------");
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(tableNum);
        for(int i=0;i<tableNum;i++) {
            executorService.submit(new Dinner("00" + (i+1), queue, count));
        }
        //计数器等待，知道队列为空（所有人吃完）
        count.await();
        long time = System.currentTimeMillis() - start;
        System.out.println("-----------------------------------所有人已经吃完-----------------------------------");
        System.out.println("共耗时：" + time);
        //停止线程池
        executorService.shutdown();
    }

    private static class Dinner implements Runnable{
        private String name;
        // 吃饭者队列，传递引用
        private ConcurrentLinkedQueue<String> queue;
        private CountDownLatch count;

        public Dinner(String name, ConcurrentLinkedQueue<String> queue, CountDownLatch count) {
            this.name = name;
            this.queue = queue;
            this.count = count;
        }

        @Override
        public void run() {
            //while (queue.size() > 0){
            while (!queue.isEmpty()){
                //从队列取出一个元素 排队的人少一个
                System.out.println("【" +queue.poll() + "】----已吃完...， 饭桌编号：" + name);
            }
            count.countDown();//计数器-1
        }
    }


}
