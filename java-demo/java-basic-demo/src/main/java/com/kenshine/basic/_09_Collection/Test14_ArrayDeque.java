package com.kenshine.basic._09_Collection;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:36
 * @description：数组实现双端队列（链表实现为LinkedList）
 * @modified By：
 * @version: $
 * 概述：
 * 底层通过循环数组实现 俩个重要属性 head tail
 * 不能添加null值，不然会报空指针
 * 每次扩容都是2的n次方
 * 可以实现普通队列先进先出排序，也可以实现栈先进后出的排序
 */
public class Test14_ArrayDeque {

    /**
     * 1.当栈来使用
     */
    @Test
    public void test01() {
        ArrayDeque stack = new ArrayDeque();
        // 依次将三个元素push入"栈"
        stack.push("循循渐进Linux");
        stack.push("小学语文");
        stack.push("时间简史");
        // 输出：[时间简史, 小学语文, 循循渐进Linux]
        System.out.println(stack);
        // 访问第一个元素，但并不将其pop出"栈"，输出：时间简史
        System.out.println(stack.peek());
        // 依然输出：[时间简史, 小学语文, 循循渐进Linux]
        System.out.println(stack);
        // pop出第一个元素，输出：时间简史
        System.out.println(stack.pop());
        // 输出：[小学语文, 循循渐进Linux]
        System.out.println(stack);
    }

    /**
     * 当做队列使用
     */
    @Test
    public void test02(){
        ArrayDeque queue = new ArrayDeque();
        // 依次将三个元素加入队列
        queue.offer("光头强");
        queue.offer("熊大");
        queue.offer("熊二");
        // 输出：[光头强, 熊大, 熊二]
        System.out.println(queue);
        // 访问队列头部的元素，但并不将其poll出队列"栈"，输出：光头强
        System.out.println(queue.peek());
        // 依然输出：[光头强, 熊大, 熊二]
        System.out.println(queue);
        // poll出第一个元素，输出：光头强
        System.out.println(queue.poll());
        // 输出：[熊大, 熊二]
        System.out.println(queue);
    }

}
