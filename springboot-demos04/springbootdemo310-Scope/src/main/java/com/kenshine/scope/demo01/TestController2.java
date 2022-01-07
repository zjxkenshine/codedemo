package com.kenshine.scope.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 9:00
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
public class TestController2 {
    @Autowired
    public TestA testA;

    @Autowired
    public TestB testB;

    @Autowired
    public TestC testC;

    @Autowired
    public TestD testD;
}
