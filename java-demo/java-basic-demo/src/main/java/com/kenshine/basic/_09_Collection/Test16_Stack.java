package com.kenshine.basic._09_Collection;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:50
 * @description：Vector的一个子类，它实现了一个标准的后进先出的栈
 * @modified By：
 * @version: $
 */
public class Test16_Stack {
    public static void main(String args[]) {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        showpop(st);
        showpop(st);
        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }

    static void showpush(Stack<Integer> st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }
}
