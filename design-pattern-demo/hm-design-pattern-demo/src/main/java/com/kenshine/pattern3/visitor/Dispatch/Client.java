package com.kenshine.pattern3.visitor.Dispatch;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 22:59
 * @description：分派测试
 * @modified By：
 * @version: $
 *
 *  动态分派
 */
public class Client {

    public static void main(String[] args) {
        Animal a = new Dog();
        a.execute();

        Animal a1 = new Cat();
        a1.execute();
    }
}
