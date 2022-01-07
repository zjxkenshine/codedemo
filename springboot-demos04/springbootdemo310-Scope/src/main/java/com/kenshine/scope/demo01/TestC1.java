package com.kenshine.scope.demo01;

import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 9:52
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class TestC1 extends TestC{
    public TestC1() {
        System.out.println("TestC1被实例化了");
    }
}
