package com.kenshine.chapter03;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/1 11:01
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
public class Test02_Create_Runnable {
    public static void main(String[] args) {
        // 使用 lambda 表达式，因为 Runnable 接口
        // 标注了 @FunctionalInterface 这个注解，表示是一个函数式接口，可以使用 lambda 表达式
        Runnable r = () -> log.debug("线程t1执行了");
        new Thread(r, "线程t1").start();
    }
}
