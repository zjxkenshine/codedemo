package com.kenshine.webflux.reactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 20:58
 * @description：
 * @modified By：
 * @version: $
 *
 *     - Flux 对象实现发布者，返回 N 个元素
 *     - Mono 实现发布者，返回 0 或者 1 个元素
 */
public class TestReactor {
    public static void main(String[] args) {
        //just方法直接声明元素 只有调用subscribe订阅后才会有输出 产生数据流
        Flux.just(1,2,3,4).subscribe(System.out::println);
        Mono.just(1);

        //其他方法
        Integer[] array = {1,2,3,4};
        Flux.fromArray(array);

        //从迭代器构建
        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);

        //从流中构建
        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);
    }
}
