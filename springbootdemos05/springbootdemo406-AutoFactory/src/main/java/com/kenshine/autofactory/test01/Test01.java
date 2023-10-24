package com.kenshine.autofactory.test01;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description 简单使用AutoFactory
 * @Date 2023-10-24 8:23
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory(()-> 1);
        Phone simplePhone = phoneFactory.create("kenshine");
        System.out.println(simplePhone);
    }
}
