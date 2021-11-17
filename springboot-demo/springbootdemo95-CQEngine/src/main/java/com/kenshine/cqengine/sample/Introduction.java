package com.kenshine.cqengine.sample;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.index.radixreversed.ReversedRadixTreeIndex;
import com.googlecode.cqengine.index.suffix.SuffixTreeIndex;
import com.googlecode.cqengine.query.Query;
import com.kenshine.cqengine.domain.Car;

import java.util.Arrays;

import static com.googlecode.cqengine.query.QueryFactory.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 14:33
 * @description：示例1
 * @modified By：
 * @version: $
 */
public class Introduction {

    public static void main(String[] args) {
        // 创建一个索引集合
        // 也可以通过CQEngine.copyFrom()从已存在的集合来创建
        IndexedCollection<Car> cars = new ConcurrentIndexedCollection<Car>();

        // 添加一些索引
        cars.addIndex(NavigableIndex.onAttribute(Car.CAR_ID));
        cars.addIndex(ReversedRadixTreeIndex.onAttribute(Car.NAME));
        cars.addIndex(SuffixTreeIndex.onAttribute(Car.DESCRIPTION));
        cars.addIndex(HashIndex.onAttribute(Car.FEATURES));

        // Add some objects to the collection...
        // 添加对象到集合中
        cars.add(new Car(1, "ford focus", "great condition, low mileage", Arrays.asList("spare tyre", "sunroof")));
        cars.add(new Car(2, "ford taurus", "dirty and unreliable, flat tyre", Arrays.asList("spare tyre", "radio")));
        cars.add(new Car(3, "honda civic", "has a flat tyre and high mileage", Arrays.asList("radio")));

        // -------------------------- 查询 --------------------------
        System.out.println("Cars whose name ends with 'vic' or whose id is less than 2:");
        Query<Car> query1 = or(endsWith(Car.NAME, "vic"), lessThan(Car.CAR_ID, 2));
        cars.retrieve(query1).forEach(System.out::println);

        System.out.println("\nCars whose flat tyre can be replaced:");
        Query<Car> query2 = and(contains(Car.DESCRIPTION, "flat tyre"), equal(Car.FEATURES, "spare tyre"));
        cars.retrieve(query2).forEach(System.out::println);


        System.out.println("\nCars which have a sunroof or a radio but are not dirty:");
        Query<Car> query3 = and(in(Car.FEATURES, "sunroof", "radio"), not(contains(Car.DESCRIPTION, "dirty")));
        cars.retrieve(query3).forEach(System.out::println);

    }
}
