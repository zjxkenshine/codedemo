package com.kenshine.metadata.demo01;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 10:26
 * @description：
 * @modified By：
 * @version: $
 */
@TestReader("bbbbbbbbbbbbbb")
@Component
public class TestA extends TestB implements Serializable {
    TestC testC;

    class TestC{
    }

    public void show(){
        System.out.println("调用了show方法");
    }
}
