package com.kenshine.cqengine.sample;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.query.parser.sql.SQLParser;
import com.googlecode.cqengine.resultset.ResultSet;
import com.kenshine.cqengine.domain.demo2.Car;
import com.kenshine.cqengine.domain.demo2.CarFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.googlecode.cqengine.codegen.AttributeBytecodeGenerator.createAttributes;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 14:42
 * @description：测试
 * @modified By：
 * @version: $
 *
 * 将汽车分组并分别计算数量
 * SQL方式demo
 */
public class SQLAggregationDemo {

    public static void main(String[] args) {
        SQLParser<Car> parser = SQLParser.forPojoWithAttributes(Car.class, createAttributes(Car.class));
        IndexedCollection<Car> cars = new ConcurrentIndexedCollection<Car>();
        cars.addAll(CarFactory.createCollectionOfCars(10));

        ResultSet<Car> results = parser.retrieve(cars, "SELECT * FROM cars");
        Map<String, List<Car>> carResultMap = results.stream().collect(Collectors.groupingBy(t -> t.getColor().toString()));

        Iterator iterator = carResultMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<Car>> entry = (Map.Entry) iterator.next();
            System.out.println("Car.color=" + entry.getKey()+", count=" + entry.getValue().size());
        }
    }

}
