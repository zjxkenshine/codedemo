package com.kenshine.corbertura.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/24 10:38
 * @description：计算
 * @modified By：
 * @version: $
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int multi(int a, int b) {
        return a * b;
    }

    public double pow(int a, int b) {
        return Math.pow(a,b);
    }

    public int abs(int a, int b) {
        return Math.abs(a)+Math.abs(b);
    }

}
