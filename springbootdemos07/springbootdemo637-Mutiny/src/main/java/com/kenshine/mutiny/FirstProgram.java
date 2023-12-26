package com.kenshine.mutiny;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.junit.Test;

import java.time.Duration;
import java.util.function.Consumer;

/**
 * @author by kenshine
 * @Classname FirstProgram
 * @Description 第一个项目
 * @Date 2023-12-26 12:17
 * @modified By：
 * @version: 1.0$
 */
public class FirstProgram {

    /**
     * 简单使用
     */
    @Test
    public void test01(){
        // uni 只能处理1项
        Uni.createFrom().item("hello")
                .onItem().transform(item -> item + " kenshine")
                .onItem().transform(String::toUpperCase)
                .subscribe().with(item -> System.out.println(">> " + item));
    }

    /**
     *  Multi 可以处理多项
     */
    @Test
    public void test02(){
        Multi.createFrom().items(1, 2, 3, 4, 5)
                .onItem().transform(i -> i * 2)
                .select().first(3)
                .onFailure().recoverWithItem(0)
                .subscribe().with(System.out::println);
    }

    /**
     * invoke同步调用
     * call异步调用
     */
    @Test
    public void test03(){
        Multi.createFrom().items(1,2,3)
                .onSubscription()
                .invoke(() -> System.out.println("Subscribed"))
                .onItem()
                .invoke(i -> System.out.println("Received item: " + i))
                .onFailure()
                .invoke(f -> System.out.println("Failed with " + f))
                .onCompletion()
                .invoke(() -> System.out.println("Completed"))
                .onCancellation()
                .invoke(() -> System.out.println("Cancelled"))
                .onRequest()
                .invoke(l -> System.out.println("Requested: " + l));

        Multi.createFrom().items(1,2,3)
                .onItem().call(i ->
                Uni.createFrom().voidItem()
                        .onItem().delayIt().by(Duration.ofSeconds(1)
                )
        );
    }

    /**
     * transform：转换
     */
    @Test
    public void test04(){
        Uni<String> someUni = Uni.createFrom().item("hello");
        someUni
                .onItem().transform(String::toUpperCase)
                .subscribe().with(
                System.out::println);
    }

    /**
     * 异步转换
     */
    @Test
    public void test05(){
        Uni<String> uni = Uni.createFrom().item("kenshine");
        uni
                .onItem().transformToUni(FirstProgram::invokeRemoteGreetingService)
                .subscribe().with(
                System.out::println,
                Throwable::printStackTrace);
    }


    /**
     * 错误处理
     */
    @Test
    public void test06(){
        Uni<String> uni = Uni.createFrom().item("kenshine");
        // 失败处理
        Uni<String> u = uni
                .onFailure().invoke((Consumer<Throwable>) System.out::println);
        // 订阅事件
        u.subscribe().with(System.out::println,
                Throwable::printStackTrace);
    }

    /**
     * .onFailure().retry() 重试
     */
    @Test
    public void test07(){
        Uni<String> uni = Uni.createFrom().item("kenshine");
        Uni<String> u = uni
                .onFailure().retry()
                // 配置延迟 最大延迟1秒
                .withBackOff(Duration.ofMillis(100), Duration.ofSeconds(1))
                .atMost(3);
        u.subscribe().with(System.out::println,
                Throwable::printStackTrace);
    }



    public static  Uni<String> invokeRemoteGreetingService(String name){
        return Uni.createFrom().item(name);
    }

}
