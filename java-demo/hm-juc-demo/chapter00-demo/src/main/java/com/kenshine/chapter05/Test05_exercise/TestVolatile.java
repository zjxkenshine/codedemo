package com.kenshine.chapter05.Test05_exercise;

public class TestVolatile {
    volatile boolean initialized = false;
    void init() {
        if (initialized) {
            return;
        }
        // 会出现问题，线程不安全
        doInit();
        initialized = true;
    }
    private void doInit() {
    }
}