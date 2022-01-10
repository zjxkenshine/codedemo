package com.kenshine.basic._09_Collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:43
 * @description：优先级队列
 * @modified By：
 * @version: $
 *
 * 与 TreeSet—样，一个优先级队列既可以保存实现了 Comparable 接口的类对象， 也可以保存在构造器中提供的 Comparator 对象
 * 无论何时调用 remove 方法，总会获得当前优先级队列中最小的元素
 * 底层是用小顶堆实现的
 */
public class Test15_PriorityQueue {
    public static void main(String[] args) {
        //优先队列自然排序示例
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
        Random rand = new Random();
        for(int i=0;i<7;i++){
            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
        }

        for(int i=0;i<7;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Processing Integer:"+in);
        }
        //优先队列使用示例
        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(customerPriorityQueue);
        pollDataFromQueue(customerPriorityQueue);
    }

    //匿名Comparator实现
    public static Comparator<Customer> idComparator = new Comparator<Customer>(){
        @Override
        public int compare(Customer c1, Customer c2) {
            return (int) (c1.getId() - c2.getId());
        }
    };

    //用于往队列增加数据的通用方法
    private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
        Random rand = new Random();
        for(int i=0; i<7; i++){
            int id = rand.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
        }
    }

    //用于从队列取数据的通用方法
    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
        while(true){
            Customer cust = customerPriorityQueue.poll();
            if(cust == null) break;
            System.out.println("Processing Customer with ID="+cust.getId());
        }
    }

}

@Data
@AllArgsConstructor
class Customer {
    private int id;
    private String name;
}
