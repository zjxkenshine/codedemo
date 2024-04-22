package com.kenshine.throwinglambda;

import com.github.fge.lambdas.Throwing;
import com.github.fge.lambdas.consumers.ConsumerChainer;
import com.github.fge.lambdas.functions.FunctionChainer;
import org.junit.Test;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author by kenshine
 * @Classname ThrowingTest
 * @Description 使用测试
 * @Date 2024-04-22 13:27
 * @modified By：
 * @version: 1.0$
 */
public class ThrowingTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        // Throwing.* 调用lambda
        Arrays.asList("a","b","c").forEach(Throwing.consumer(System.out::println));
        Stream.of("a","b","c","d").filter(Throwing.predicate("d"::equals)).forEach(Throwing.consumer(System.out::println));
        Stream.of("a","b","c","d").map(Throwing.function(String::toUpperCase)).forEach(Throwing.consumer(System.out::println));
    }

    /**
     * 自定义处理方式
     * .orThrow()：抛出自定义异常
     * .orTrywith()：执行另一个lambda
     * .fallbackTo()：回退到不可丢弃的lambda
     */
    @Test
    public void test02(){
        int a=Throwing.intSupplier(() -> 1/0).orTryWith(()->1).orThrow(RuntimeException.class).getAsInt();
        System.out.println(a);
    }

    /**
     * 其他自定义函数
     * 除consumer:.orReturn(someValue)
     * consumer:.orDoNothing()
     * UnaryOperator一元运算: .orReturnSelf()
     * BinaryOperator二元运算: .orReturnLeft(), .orReturnRight()
     */
    @Test
    public void test03(){
        ConsumerChainer<Object> consumer=Throwing.consumer(System.out::println);
        Arrays.asList("a","b","c").forEach(consumer.orDoNothing());
    }
}
