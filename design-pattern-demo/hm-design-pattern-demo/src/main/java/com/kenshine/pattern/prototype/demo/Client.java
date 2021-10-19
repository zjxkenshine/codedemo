package com.kenshine.pattern.prototype.demo;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 21:37
 * @description：测试类
 * @modified By：
 * @version: $
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype r1 = new Realizetype();
        //原型创建的对象
        Realizetype r2 = r1.clone();
        //不是同一个对象 false
        System.out.println("对象r1和r2是同一个对象？" + (r1 == r2));
    }
}
