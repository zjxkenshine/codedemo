package com.kenshine.chapter03;

import static org.junit.runner.Request.method;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/4 19:07
 * @description：测试栈帧
 * @modified By：
 * @version: $
 */
public class Test04_Frames {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                method1(20);
            }
        };
        t1.setName("线程t1");
        t1.start();
        method1(10);
    }

    public static void method1(int x){
        int y = x + 1;
        Object m = method2();
        System.out.println(m);
    }

    public static Object method2(){
        Object n = new Object();
        return n;
    }
}
