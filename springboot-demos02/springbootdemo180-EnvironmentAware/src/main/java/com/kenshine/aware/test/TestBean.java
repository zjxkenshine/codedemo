package com.kenshine.aware.test;

import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 23:00
 * @description：
 * @modified By：
 * @version: $
 */
public class TestBean {
    /**
     * 用于测试的bean
     */
    public void test(){
        System.out.println("我是测试Bean");
    }

    public String getSuccess(){
        return "success";
    }
}
