package com.kenshine.basic._02_generic;

import org.junit.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 10:53
 * @description：泛型边界
 * @modified By：
 * @version: $
 *
 * <? extends T>：是指 “上界通配符（Upper Bounds Wildcards）”
 * <? super T>：是指 “下界通配符（Lower Bounds Wildcards）”
 *
 *
 * 上界<? extends T>不能往里存，只能往外取
 * 下界<? super T>可以往里存，但往外取只能放在Object对象里
 *
 * PECS原则
 * 最后看一下什么是PECS（Producer Extends Consumer Super）原则，已经很好理解了：
 *  - 频繁往外读取内容的，适合用上界Extends。生产者
 *  - 经常往里插入的，适合用下界Super。消费者
 */
public class test09_GenericBounds {

    //1.<? extends Fruit> 的理解 只能读取，不能存入 生产者
    @Test
    public void test01(){
        Plate<? extends Fruit> p=new Plate<>(new Apple());
        //不能存入任何元素
        //p.set(new Fruit());    //Error
        //p.set(new Apple());    //Error

        //读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1=p.get();
        Object newFruit2=p.get();
        //Apple newFruit3=p.get();    //Error
    }

    //2.<? super Fruit> 可以存入，但读取的只能放到Object中
    @Test
    public void test02(){
        Plate<? super Fruit> p=new Plate<>(new Fruit());

        //存入元素正常
        p.set(new Fruit());
        p.set(new Apple());

        //读取出来的东西只能存放在Object类里。
        //Apple newFruit3=p.get();    //Error
        //Fruit newFruit1=p.get();    //Error
        Object newFruit2=p.get();
    }


}

//盘子
class Plate<T>{
    private T item;
    public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}
}

//Lev 1
class Food{}

//Lev 2
class Fruit extends Food{}
class Meat extends Food{}

//Lev 3
class Apple extends Fruit{}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}

//Lev 4
class RedApple extends Apple{}
class GreenApple extends Apple{}

