package com.kenshine.autofactory.test04;

import org.checkerframework.checker.units.qual.C;

/**
 * @author by kenshine
 * @Classname Test04
 * @Description 测试继承
 * @Date 2023-10-24 9:11
 * @modified By：
 * @version: 1.0$
 */
public class Test04 {
    public static void main(String[] args) {
        CustomPhoneFactory factory=new CustomPhoneFactory();
        CustomPhone phone=factory.create("aaaa");
        System.out.println(phone);
    }
}
