package com.kenshine.autofactory.test03;

/**
 * @author by kenshine
 * @Classname Test03
 * @Description 测试
 * @Date 2023-10-24 9:03
 * @modified By：
 * @version: 1.0$
 */
public class Test03 {
    public static void main(String[] args) {
        User user=new student().getUser(1,"kenshine");
        System.out.println(user);
    }
}
