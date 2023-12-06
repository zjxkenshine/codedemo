package com.kenshine.streamutils;

import org.junit.Test;
import org.paumard.streams.StreamsUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author by kenshine
 * @Classname StreamUtilsTest
 * @Description 使用测试
 * @Date 2023-12-06 11:15
 * @modified By：
 * @version: 1.0$
 */
public class StreamUtilsTest {

    /**
     * Cycling 取一个流并永远重复它，只要这个流的大小是有限的
     */
    @Test
    public void test01(){
        Stream<String> strings = Stream.of("one", "two");

        // 重复元素
        List<String> list = StreamsUtils.cycle(strings)
                .limit(3)
                // Function.identity()返回一个输出跟输入一样的Lambda表达式对象
                .collect(toList());
        System.out.println(list);
    }

    /**
     * 基本分组
     */
    @Test
    public void test02(){
        Stream<String> strings = Stream.of("a","b","c","d");
        // 2个一组
        Stream<Stream<String>> groupingStream = StreamsUtils.group(strings, 2);
        List<List<String>> collect = groupingStream.map(st -> st.collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 自定义分组分隔符
     */
    @Test
    public void test03(){
        Stream<String> stream = Stream.of("o", "a0", "a1", "a2", "c", "a3", "a4", "o", "a5", "c");
        // 自定义起始字符与结束字符
        Stream<Stream<String>> groupingStream = StreamsUtils.group(stream, "o"::equals, "c"::equals);
        List<List<String>> collect = groupingStream.map(st -> st.collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * repeat重复整个流
     * 有问题
     */
    @Test
    public void test04(){
        Stream<String> stream = Stream.of("a0", "a1", "a2", "a3");
        Stream<String> repeatingStream = StreamsUtils.repeat(stream, 5);
        List<String> collect = repeatingStream.collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * roll 滚动生成流
     */
    @Test
    public void test05(){
        Stream<String> stream = Stream.of("a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7");
        Stream<Stream<String>> rollingStream = StreamsUtils.roll(stream, 3);
        List<List<String>> collect = rollingStream.map(st -> st.collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * traverse每次从所提供的流中获取一个元素，并将它们放入子流中，从而生成流。
     * 行转列类似
     */
    @Test
    public void test06(){
        Stream<String> stream0 = Stream.of("a00", "a01", "a02", "a03");
        Stream<String> stream1 = Stream.of("a10", "a11", "a12", "a13");
        Stream<String> stream2 = Stream.of("a20", "a21", "a22", "a23");
        Stream<String> stream3 = Stream.of("a30", "a31", "a32", "a33");
        Stream<Stream<String>> traversingStream = StreamsUtils.traverse(stream0, stream1, stream2, stream3);
        List<List<String>> collect = traversingStream.map(st -> st.collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * weave 每个流取一个元素生成一个流
     */
    @Test
    public void test07(){
        Stream<String> stream0 = Stream.of("a00", "a01", "a02");
        Stream<String> stream1 = Stream.of("a10", "a11", "a12");
        Stream<String> stream2 = Stream.of("a20", "a21", "a22");
        Stream<String> weavingStream = StreamsUtils.weave(stream0, stream1, stream2);
        List<String> collect = weavingStream.collect(toList());
        System.out.println(collect);
    }

    /**
     *zip 压缩合并流
     */
    @Test
    public void test08(){
        Stream<String>  stream0 = Stream.of("a", "b", "c", "d");
        Stream<Integer> stream1 = Stream.of(0, 1, 2, 3);
        BiFunction<String, Integer, String> zipper = (s, i) -> s + "-" + i;
        Stream<String> zippingStream = StreamsUtils.zip(stream0, stream1, zipper);
        List<String> collect = zippingStream.collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     *validate 验证并生成流
     * if(参数1){参数2}else{参数3}
     */
    @Test
    public void test09(){
        Stream<String>  stream = Stream.of("a", "b", "c", "da","ae");
        Stream<String> validateStream = StreamsUtils.validate(stream,(s)-> s.contains("a"),s -> s,s -> s+"a");
        List<String> collect = validateStream.collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * interrupt 生成一个与所提供的流相同的流，直到其中一个元素的中断器谓词为假。这时，返回的流停止
     */
    @Test
    public void test10(){
        Stream<String>  stream = Stream.of("a", "b", "c", "d","e");
        Stream<String> stream1 = StreamsUtils.interrupt(stream, "c"::equals);
        List<String> collect = stream1.collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * gate生成一个不生成任何元素的流，直到所提供流的一个元素的验证器为真。从这里开始，返回流与提供的流是相同的。
     */
    @Test
    public void test11(){
        Stream<String>  stream = Stream.of("a", "b", "c", "d","e");
        Stream<String> stream1 = StreamsUtils.gate(stream, "c"::equals);
        List<String> collect = stream1.collect(Collectors.toList());
        System.out.println(collect);
    }


}
