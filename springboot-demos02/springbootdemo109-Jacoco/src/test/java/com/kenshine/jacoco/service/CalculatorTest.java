package com.kenshine.jacoco.service;

import com.kenshine.jacoco.JacocoApp;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/24 10:40
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JacocoApp.class)
class CalculatorTest {
    private Calculator instance = new Calculator();

    @Test
    void testAdd() {
        int a = 10;
        int b = 20;
        int expected = 30;
        Assert.assertEquals(expected, instance.add(a, b));
    }

    @Test
    void testSub() {
        int a = 10;
        int b = 20;
        int expected = -10;
        Assert.assertEquals(expected, instance.sub(a, b));
    }
}