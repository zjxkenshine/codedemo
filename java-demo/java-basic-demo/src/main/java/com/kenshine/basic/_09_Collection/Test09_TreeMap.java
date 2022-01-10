package com.kenshine.basic._09_Collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:14
 * @description：
 * @modified By：
 * @version: $
 * TreeMap的实现是红黑树算法的实现
 *
 */
public class Test09_TreeMap {
    public static void main(String[] args) {
        //1、使用默认的TreeMap 构造函数，其中key值需要有比较规则
        TreeMap<Integer, String> map =new TreeMap<>();
        map.put(new Integer(2), "BB");
        map.put(new Integer(1), "AA");
        map.put(new Integer(5), "EE");
        map.put(new Integer(3), "CC");
        map.put(new Integer(4), "DD");
        map.put(new Integer(2), "AA");   //验证重复key是否能够插入

        //使用遍历EntrySet方式
        for(Map.Entry<Integer, String> entry:map.entrySet()){
            System.out.println("Key:"+entry.getKey()+ " --- value:"+entry.getValue());
        }

        //2、使用默认的TreeMap 构造函数，Key中添加自定义类型,自定义类型必须继承Comparator
        System.out.println("-------------------2、使用默认的TreeMap 构造函数，Key中添加自定义类型,自定义类型必须继承Comparator-----------------------");
        TreeMap<person,String> mapPer=new TreeMap<>();
        mapPer.put(new person("张三",22), "6K");
        mapPer.put(new person("老王",35), "29K");
        mapPer.put(new person("小张",31), "11K");
        for(Map.Entry<person, String> entry:mapPer.entrySet()){
            System.out.println("Key:"+entry.getKey()+ " --- value:"+entry.getValue());
        }

        //3、使用比较器类来来实现排序，自定义类型不用来继承Comparator
        System.out.println("-------------------3、使用比较器类来来实现排序，自定义类型不用来继承Comparator-----------------------");
        TreeMap<Book1,String> mapBook =new TreeMap<>(new BookComparator());
        mapBook.put(new Book1("流浪地球",60),"200页");
        mapBook.put(new Book1("三体",100),"400页");
        mapBook.put(new Book1("大秦帝国",180),"900页");
        for(Map.Entry<Book1, String> entry:mapBook.entrySet()){
            System.out.println("Key:"+entry.getKey()+ " --- value:"+entry.getValue());
        }
    }
}

@Data
@AllArgsConstructor
class person implements Comparable<person> {
    String name;
    int age;

    @Override
    public int compareTo(person o) {
        if(o.age>this.age) {
            return 1;
        } else if(o.age<this.age) {
            return -1;
        }
        return 0;
    }
}

@Data
@AllArgsConstructor
class Book1{
    String name;
    double price;
}

//自定义比较器
class BookComparator implements Comparator<Book1> {
    @Override
    public int compare(Book1 o1, Book1 o2) {
        if(o1.price>o2.price) {
            return 1;
        } else if(o1.price<o2.price) {
            return -1;
        }
        return 0;
    }
}
