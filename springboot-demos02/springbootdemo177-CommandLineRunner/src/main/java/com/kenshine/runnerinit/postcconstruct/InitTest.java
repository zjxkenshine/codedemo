package com.kenshine.runnerinit.postcconstruct;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 23:05
 * @description：初始化测试
 * @modified By：
 * @version: $
 */
@Component
public class InitTest {

    public InitTest(){
        System.out.println("InitTest构造器执行了");
    }

    @PostConstruct
    private void init(){
        System.out.println("PostConstruct 注解初始化数据.");
    }
}
