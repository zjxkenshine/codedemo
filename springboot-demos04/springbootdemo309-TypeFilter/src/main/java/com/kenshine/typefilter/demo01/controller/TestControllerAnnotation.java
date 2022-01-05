package com.kenshine.typefilter.demo01.controller;

import com.kenshine.typefilter.demo01.annotation.Custom;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 8:53
 * @description：
 * @modified By：
 * @version: $
 */
@Custom
public class TestControllerAnnotation {
    public TestControllerAnnotation() {
        System.out.println("TestControllerAnnotation 被自定义注解 @Custom 注册了");
    }
}
