package com.kenshine.ratpack.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ratpack.server.RatpackServer;

import static ratpack.spring.Spring.spring;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 11:15
 * @description：
 * @modified By：
 * @version: $
 * 使用方式一：在RatPack中嵌入Spring
 */
public class Main {
    public static void main(String[] args) throws Exception {
        RatpackServer.start(server -> server
                .registry(spring(MyConfiguration.class))
                .handlers(chain -> chain
                        .get(ctx -> ctx
                                .render("Hello " + ctx.get(Service.class).message()))
                        .get(":message", ctx -> ctx
                                .render("Hello " + ctx.getPathTokens().get("message") + "!")
                        )
                )
        );
    }
}
