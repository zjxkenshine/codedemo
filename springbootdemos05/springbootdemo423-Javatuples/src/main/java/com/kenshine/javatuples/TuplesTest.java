package com.kenshine.javatuples;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Septet;
import org.javatuples.Triplet;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TuplesTest
 * @Description 测试
 * @Date 2023-10-27 15:57
 * @modified By：
 * @version: 1.0$
 */
public class TuplesTest {

    /**
     * 创建元组
     */
    @Test
    public void test01(){
        Pair<String, Integer> pair = Pair.with("kenshine1", 12);
        Pair<String, Integer> person = new Pair<>("kenshine2", 15);
        System.out.println(pair);
        System.out.println(person);

        List<String> listOf4Names = Arrays.asList("A1","A2","A3","A4");
        Quartet<String, String, String, String> quartet = Quartet.fromCollection(listOf4Names);
        System.out.println(quartet);
        List<String> listOf4Names1 = Arrays.asList("A1","A2","A3","A4");
        Pair<String, String> pair1 = Pair.fromIterable(listOf4Names1, 2);
        System.out.println(pair1);
    }

    /**
     * 获取值
     */
    @Test
    public void test02(){
        Pair<String, Integer> pair = Pair.with("kenshine", 12);
        System.out.println("Name : "+ pair.getValue0());
        System.out.println("Exp : "+ pair.getValue1());

        // getValue(index)
        Pair<String, Integer> pair1 = Pair.with("kenshine1", 12);
        System.out.println("Name : "+ pair1.getValue(0));
        System.out.println("Exp : "+ pair1.getValue(1));
    }

    /**
     * 设置值
     */
    @Test
    public void test03(){
        Pair<String, Integer> pair = Pair.with("kenshine", 12);
        Pair<String, Integer> modifiedPair = pair.setAt0("kenshine1");
        System.out.println(pair);
        System.out.println(modifiedPair);
    }

    /**
     * 添加元组元素
     */
    @Test
    public void test04(){
        // 添加元素
        Pair<String, Integer> pair = Pair.with("kenshine", 12);
        Triplet<String, Integer, String> triplet = pair.add("IT Professional");
        System.out.println(pair);
        System.out.println(triplet);

        // 合并元组
        Triplet<String, String, String> triplet1 = Triplet.with("Java", "C", "C++");
        Quartet<String, String, String, String> quartet = triplet1.addAt1("Python");
        Septet septet = quartet.add(triplet);
        System.out.println(triplet);
        System.out.println(quartet);
        System.out.println(septet);

        // addAtn 添加到某个位置
        Triplet<String, String, String> t = Triplet.with("Java", "C", "C++");
        Quartet<String, String, String, String> q = t.addAt1("Python");
        System.out.println(t);
        System.out.println(q);
    }

    /**
     * 转换为集合或数组
     */
    @Test
    public void test05(){
        Quartet<String, Integer, String, Double> quartet1 = Quartet.with("A1",1,"A3",2.3);
        List<Object> quartletList = quartet1.toList();
        System.out.println(quartletList);
        // 转换为数组
        Object[] quartletArr = quartet1.toArray();
        System.out.println(Arrays.toString(quartletArr));
    }

    /**
     * 迭代值
     */
    @Test
    public void test06(){
        Quartet<String, Integer, String, Double> quartet1 = Quartet.with("A1",1,"A3",2.3);
        for(Object obj : quartet1) {
            System.out.println(obj);
        }
    }



}
