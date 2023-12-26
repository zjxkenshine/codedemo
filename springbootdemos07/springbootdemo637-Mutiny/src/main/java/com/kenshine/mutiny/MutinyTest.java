package com.kenshine.mutiny;

import io.smallrye.mutiny.Uni;

import java.io.IOException;

import static java.time.Duration.ofMillis;

/**
 * @author by kenshine
 * @Classname MutinyTest
 * @Description 官方示例
 * @Date 2023-12-26 13:15
 * @modified By：
 * @version: 1.0$
 */
public class MutinyTest {
    public static void main(String[] args) {
        String params="";
        // 请求封装为uni
        Uni<String> request = makeSomeNetworkRequest(params);
        // 请求处理
        request.ifNoItem().after(ofMillis(100))
                .failWith(() -> new Exception("fail"))
                .onFailure(IOException.class).recoverWithItem(fail -> "fail")
                .subscribe().with(
                System.out::println,
                err -> System.out.println(err.getMessage())
        );
    }

    private static Uni<String> makeSomeNetworkRequest(String params) {
        return Uni.createFrom().item(params);
    }
}
