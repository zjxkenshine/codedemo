package com.kenshine.corbertura.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 14:03
 * @description：
 * @modified By：
 * @version: $
 */
class CalculatorTest {
    private Calculator instance = new Calculator();

    @Test
    void add() {
        int a = 10;
        int b = 20;
        int expected = 30;
        Assert.assertEquals(expected, instance.add(a, b));
    }

    @Test
    void sub() {
        int a = 10;
        int b = 20;
        int expected = -10;
        Assert.assertEquals(expected, instance.sub(a, b));
    }

    @Test
    void multi() {
        int a = 10;
        int b = 20;
        int expected = 200;
        Assert.assertEquals(expected, instance.multi(a, b));
    }


    @Test
    void abs() {
        int a = -10;
        int b = -20;
        int expected = 30;
        Assert.assertEquals(expected, instance.abs(a, b));
    }
}