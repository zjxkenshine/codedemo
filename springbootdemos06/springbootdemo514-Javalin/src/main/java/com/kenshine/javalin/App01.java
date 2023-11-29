package com.kenshine.javalin;

import io.javalin.Javalin;

/**
 * @author by kenshine
 * @Classname Application
 * @Description Javalin使用测试
 * @Date 2023-11-29 11:28
 * @modified By：
 * @version: 1.0$
 */
public class App01 {
    /**
     * localhost:7000 基本使用
     */
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", context -> context.result("Hello World"));
    }
}
