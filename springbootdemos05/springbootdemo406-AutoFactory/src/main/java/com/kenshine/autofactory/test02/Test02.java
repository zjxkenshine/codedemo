package com.kenshine.autofactory.test02;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description 自动生成
 * @Date 2023-10-24 8:51
 * @modified By：
 * @version: 1.0$
 */
public class Test02 {
    public static void main(String[] args) {
        ClassicPhoneFactory factory = new ClassicPhoneFactory(()->"a");
        ClassicPhone phone = factory.create("kenshine");
        System.out.println(phone);
    }
}
