package com.kenshine.designpattern.gof11_Composite.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 19:42
 * @description：
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        Component b0 = new Branch();
        Component b1 = new Branch();
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");
        b0.add(leaf1);
        b0.add(b1);
        b1.add(leaf2);
        b1.add(leaf3);
        b0.operation();
    }
}
