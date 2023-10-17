package com.kenshine.aspectj;

import com.kenshine.aspectj.model.Account;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 测试
 * @Date 2023-10-17 8:27
 * @modified By：
 * @version: 1.0$
 */
public class AspectjTest {
    public static void main(String[] args) {
        testCompileTime();
    }
    public static void testCompileTime() {
        Account account = new Account();
        System.out.println("==================");
        account.pay(10);
        account.pay(50);
        System.out.println("==================");
    }
}
