package com.kenshine.designpattern.gof16_Template.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/21 22:20
 * @description：
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass abstractClass;

        abstractClass = new ConcreteClassA();
        abstractClass.TemplateMethod();
        System.out.println();
        abstractClass = new ConcreteClassB();
        abstractClass.TemplateMethod();
    }
}
