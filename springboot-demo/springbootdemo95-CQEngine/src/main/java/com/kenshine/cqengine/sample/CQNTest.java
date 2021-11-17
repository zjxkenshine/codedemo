package com.kenshine.cqengine.sample;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.query.parser.cqn.CQNParser;
import com.googlecode.cqengine.resultset.ResultSet;
import com.kenshine.cqengine.domain.demo2.Car;
import com.kenshine.cqengine.domain.demo2.CarFactory;

import static com.googlecode.cqengine.codegen.AttributeBytecodeGenerator.createAttributes;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 14:47
 * @description：CQN方式查询
 * @modified By：
 * @version: $
 */
public class CQNTest {
    public static void main(String[] args) {
        CQNParser<Car> parser = CQNParser.forPojoWithAttributes(Car.class, createAttributes(Car.class));
        IndexedCollection<Car> cars = new ConcurrentIndexedCollection<Car>();
        cars.addAll(CarFactory.createCollectionOfCars(10));

        ResultSet<Car> results = parser.retrieve(cars,
                "and(" +
                        "or(equal(\"manufacturer\", \"Ford\"), equal(\"manufacturer\", \"Honda\")), " +
                        "lessThanOrEqualTo(\"price\", 5000.0), " +
                        "not(in(\"color\", GREEN, WHITE))" +
                        ")");

        results.forEach(System.out::println); // Prints: Ford Focus, Ford Fusion, Honda Accord

    }
}
