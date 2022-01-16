package com.kenshine.spring5demo08;

import com.kenshine.spring5demo08.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 22:47
 * @description： 使用WebClient
 * @modified By：
 * @version: $
 */
public class Client {

    public static void main(String[] args) {
        //调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:8080");
        //根据 id 查询
        String id = "1";
        User userResult = webClient.get().uri("/user/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();  //block 闭包，订阅执行并返回元素
        System.out.println(userResult.getName());

        //查询所有
        Flux<User> results = webClient.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
        //map映射输出姓名
        results.map(User::getName)
                .buffer().doOnNext(System.out::println).blockFirst();
    }

}
