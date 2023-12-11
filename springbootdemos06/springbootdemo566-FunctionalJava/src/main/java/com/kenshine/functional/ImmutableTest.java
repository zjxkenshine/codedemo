package com.kenshine.functional;

import fj.*;
import fj.data.*;
import fj.data.hlist.HList;
import fj.data.hlist.HList.*;
import fj.function.Integers;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ImmutableTest
 * @Description 不可变类测试
 * @Date 2023-12-11 8:02
 * @modified By：
 * @version: 1.0$
 */
public class ImmutableTest {

    /**
     * Array<String> 不可变数组，Array包装类
     */
    @Test
    public void test01Array(){
        Array<String> array = Array.array("kenshine","lin","qin");
        System.out.println(array);
        Array<String> array2 = array.append(Array.array("cc","seven"));
        System.out.println(array2);
        Array<String> array3 = array2.filter(new F<String, Boolean>() {
            @Override
            public Boolean f(String s) {
                return s.length()>2;
            }
        });
        System.out.println(array3);
        Array<String> array4 = array3.reverse();
        System.out.println(array4);
    }

    /**
     * List<A>不可变，内存中的单链表
     */
    @Test
    public void test02List(){
        List<String> list = List.list("a","b","c","d");
        // 为每个元素应用转换
        List<String> list1 =list.bind(new F<String, List<String>>() {
            @Override
            public List<String> f(String s) {
                return List.list("a"+s);
            }
        });
        System.out.println(list1);
        List<String> list2=list1.append(List.list("e"));
        System.out.println(list2);
        // 转为其他类型流
        List<String> list3=list2.map(new F<String, String>() {
            @Override
            public String f(String s) {
                return "test_"+s;
            }
        });
        System.out.println(list3);
    }

    /**
     * Stream 不可变惰性单链表
     */
    @Test
    public void test03Stream(){
        Stream<String> stream1 = Stream.stream("s1","s2");
        // 绑定到子流
        Stream<String> stream2 = stream1.cobind(new F<Stream<String>, String>() {
            @Override
            public String f(Stream<String> strings) {
                return "test";
            }
        });
        Stream<Stream<String>> streams=stream2.substreams();
        System.out.println(streams.toJavaList());
        Stream<String> stream3 =streams.map(new F<Stream<String>, String>() {
            @Override
            public String f(Stream<String> strings) {
                return "test1_"+strings.length();
            }
        });
        System.out.println(stream3.toJavaList());
    }

    /**
     * FingerTrees<V,A> 2-3指树实现，在O(1)时间访问末梢
     * V：注释节点的单体类型，A：节点数据类型
     * Deep<V,A> 左右各有1-4个数字的手指树，在中间有2-3个节点的手指树。
     * Measured<V, A> 确定如何度量树的元素以及如何求和
     * One<V,A>指树的单个元素前缀或后缀
     */
    @Test
    public void test04FingerTrees(){
        //在PriorityQueue源码中有使用
        //详见test09PriorityQueue
    }

    /**
     * HList 类型安全异构列表
     */
    @Test
    public void test05HList(){
        final HCons<String, HCons<Integer, HCons<Boolean, HNil>>> a =
                // 添加不同数据类型数据
                HList.nil().extend(true).extend(3).extend("Foo");
        final HCons<Double, HCons<String, HCons<Integer[], HNil>>> b =
                HList.nil().extend(new Integer[]{1, 2}).extend("Bar").extend(4.0);
        // 取最后一个添加的
        System.out.println(a.head());
        // 取倒数第二个值
        System.out.println(b.tail().head());
    }

    /**
     * Set<A> 提供一个内存中的不可变集，实现为红/黑树
     * Ord<A> 元素提供接口
     */
    @Test
    public void test06Set(){
        Set<String> set = Set.set(Ord.comparableOrd(),"kenshine","lin","pig");
        System.out.println(set.max().some());
        System.out.println(set);
    }

    /**
     * Tree 玫瑰树 不可变多路树
     */
    @Test
    public void test07Tree(){
        Tree<String> tree = Tree.node("root",List.list(Tree.leaf("A"),Tree.leaf("B"),Tree.leaf("C")));
        System.out.println(tree.draw(Show.anyShow()));
    }

    /**
     * TreeMap 不可变Map，红黑树实现
     * Integers integer相关的函数
     */
    @Test
    public void test08TreeMap(){
        TreeMap<String, Integer> map = TreeMap.empty(Ord.stringOrd);
        map = map.set("foo", 2);
        map = map.update("foo", Integers.add.f(3))._2();
        System.out.println(map.get("foo").some());
    }

    /**
     * PriorityQueue<K, A> 使用fingerTree实现的不可变优先队列
     * K 权值，A 值
     */
    @Test
    public void test09PriorityQueue(){
        PriorityQueue<Integer,String> p1 = PriorityQueue.emptyInt();
        // 添加
        PriorityQueue<Integer,String> p2=p1.enqueue(11,"t1").enqueue(22,"t2").enqueue(14,"t3");
        // 移除最高权值
        PriorityQueue<Integer,String> p3=p2.dequeue();
        System.out.println(p2);
        System.out.println(p3);
    }

}
