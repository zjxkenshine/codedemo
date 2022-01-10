package com.kenshine.basic._09_Collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 21:42
 * @description：
 * @modified By：
 * @version: $
 *
 * （1）线程安全：HashMap是线程不安全的类，多线程下会造成并发冲突，但单线程下运行效率较高；HashTable是线程安全的类，很多方法都是用synchronized修饰，但同时因为加锁导致并发效率低下，单线程环境效率也十分低；
 * （2）插入null：HashMap允许有一个键为null，允许多个值为null；但HashTable不允许键或值为null；
 * （3）容量：HashMap底层数组长度必须为2的幂，这样做是为了hash准备，默认为16；而HashTable底层数组长度可以为任意值，这就造成了hash算法散射不均匀，容易造成hash冲突，默认为11；
 * （4）Hash映射：HashMap的hash算法通过非常规设计，将底层table长度设计为2的幂，使用位与运算代替取模运算，减少运算消耗；而HashTable的hash算法首先使得hash值小于整型数最大值，再通过取模进行散射运算；
 */
public class Test05_Hashtable {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();

        //[1]添加元素
        table.put("zhangsan", 22);
        table.put("lisi", 33);
        table.put("wangwu", 44);

        //[2]toString()方式打印
        System.out.println(table.toString());

        //[3]Iterator遍历方式1--键值对遍历entrySet()
        Iterator<Map.Entry<String, Integer>> iter = table.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("entrySet:"+key+" "+value);
        }

        System.out.println("====================================");

        //[4]Iterator遍历方式2--key键的遍历
        Iterator<String> iterator = table.keySet().iterator();
        while(iterator.hasNext()){
            String key = (String)iterator.next();
            int value = table.get(key);
            System.out.println("keySet:"+key+" "+value);
        }

        System.out.println("====================================");

        //[5]通过Enumeration来遍历Hashtable
        Enumeration<String> enu = table.keys();
        while(enu.hasMoreElements()) {
            System.out.println("Enumeration:"+table.keys()+" "+enu.nextElement());
        }
    }
}
