package com.kenshine.collectorsutils;

import org.junit.Test;
import org.paumard.collectors.CollectorsUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author by kenshine
 * @Classname CollectorsTest
 * @Description 收集器使用测试
 * @Date 2023-12-11 17:37
 * @modified By：
 * @version: 1.0$
 */
public class CollectorsTest {

    /**
     * `findMostFrequent()`：这个收集器返回流中所有最常见的值的集合。如果有几个最常见的值，则它们都存在于集合中
     * `streamMostFrequent()`：将结果放入流中，以便进行进一步处理。
     */
    @Test
    public void test01(){
        List<String> list = Arrays.asList("a","b","a","c","b","d","e");
        // 最频繁的
        Set<Map.Entry<String, Long>> str=list.stream().collect(CollectorsUtils.findMostFrequent());
        System.out.println(str);
        // streamMostFrequent最频繁的转为流
        List<String> stringList=list.stream().collect(CollectorsUtils.streamMostFrequent()).map(Map.Entry::getKey).collect(toList());
        System.out.println(stringList);
    }

    /**
     * groupingByAndMaxBy 分组并比较大小,取一个最大值
     */
    @Test
    public void test02(){
        Stream<String> strings = Stream.of("one", "two", "two", "three", "three", "four", "four", "four");

        Collector<String, ?, Optional<Map.Entry<String, Long>>> collector =
                CollectorsUtils.groupingByAndMaxBy(
                        // 元素不进行转换
                        Function.identity(),
                        // 统计数量
                        counting(),
                        // 比较count值
                        Map.Entry.comparingByValue()
                );
        Optional<Map.Entry<String, Long>> result = strings.collect(collector);
        System.out.println(result);
    }

    /**
     *  groupingByAndAllMaxBy 分组并比较大小,取所有最大值
     */
    @Test
    public void test03(){
        Stream<String> strings = Stream.of("one", "two", "two", "three", "three", "four", "four", "four","five");
        Stream<String> strings1 = Stream.of("one", "two", "two", "three", "three", "four", "four", "four","five");
        // groupingByAndStreamAllMaxBy
        Collector<String, ?, Stream<Map.Entry<String, Long>>> collector =
                CollectorsUtils.groupingByAndStreamAllMaxBy(
                        Function.identity(),
                        counting(),
                        // 比较值 提供Comparator实现
                        Map.Entry.comparingByKey(String::compareTo)
                );
        List<Map.Entry<String, Long>> result = strings.collect(collector).collect(toList());
        System.out.println(result);
        // groupingByAndAllMaxByValue
        Collector<String, ?, Set<Map.Entry<String, Long>>> collector1 =
                CollectorsUtils.groupingByAndAllMaxByValue(
                        Function.identity(),
                        counting()
                );
        Set<Map.Entry<String, Long>> result1 = strings1.collect(collector1);
        System.out.println(result1);
    }

    /**
     * groupingByAndMaxesBy() 分组并选择符合条件的尽可能多的元素
     */
    @Test
    public void test04(){
        Stream<String> strings = Stream.of("one", "two", "two", "three", "three", "four", "four", "four");

        // groupingByAndMaxesBy 分组并选择counting>=2的结果
        Collector<String, ?, List<Map.Entry<String, Long>>> collector =
                CollectorsUtils.groupingByAndMaxesBy(
                        Function.identity(),
                        counting(),
                        2,
                        Map.Entry.comparingByValue()
                );

        List<Map.Entry<String, Long>> result = strings.collect(collector);
        System.out.println(result);
    }

    /**
     * mapToStream() 转换为流的收集器
     */
    @Test
    public void test05(){
        Stream<String> strings = Stream.of("one", "two", "three", "four", "five", "six");
        // 分组并转换为Stream
        Map<Integer, Stream<String>> map =
                strings.collect(
                        // 以长度分组，转换为stream
                        Collectors.groupingBy(
                                String::length,
                                CollectorsUtils.mapToStream()
                        )
                );
        // 长度为3的值
        System.out.println(map.get(3).collect(toList()));
    }

    /**
     * toMapThenStream 转换后转Stream
     * groupingByThenStream 分组后转Stream
     */
    @Test
    public void test06(){
        // 映射并转换为stream
        Stream<String> strings = Stream.of("one", "three", "four");
        Collector<String, ?, Stream<Map.Entry<Integer, String>>> collector =
                CollectorsUtils.toMapThenStream(
                        // 转换为length
                        String::length,
                        s -> s
                );
        List<Map.Entry<Integer, String>> entries = strings.collect(collector).collect(toList());
        System.out.println(entries);

        // 分组并转换为stream
        Stream<String> strings1 = Stream.of("one", "two", "three", "four");
        Collector<String, ?, Stream<Map.Entry<Integer, List<String>>>> groupingByThenStream =
                CollectorsUtils.groupingByThenStream(
                        String::length
                );
        List<Map.Entry<Integer, List<String>>> entries1 =
                strings1.collect(groupingByThenStream).collect(Collectors.toList());
        System.out.println(entries1);
    }

    /**
     * flatMapping 从每个元素生成流，并转换
     */
    @Test
    public void test07(){
        Stream<String> strings = Stream.of("one", "two", "three");
        Function<String, Stream<Character>> streamMapper = string -> string.chars().mapToObj(letter -> (char)letter);
        // 每个元素流执行streamMapper映射
        Collector<String, ?, Stream<Character>> streamCollector = CollectorsUtils.flatMapping(streamMapper);
        // 还需要配合其他收集器
        List<Character> characters = strings.collect(streamCollector).collect(toList());
        System.out.println(characters);
    }



}
