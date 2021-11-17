package com.kenshine.cqengine.sample;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.query.parser.sql.SQLParser;
import com.googlecode.cqengine.resultset.ResultSet;
import com.kenshine.cqengine.domain.demo2.Car;
import com.kenshine.cqengine.domain.demo2.CarFactory;

import static com.googlecode.cqengine.codegen.AttributeBytecodeGenerator.createAttributes;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 14:46
 * @description：SQL方式测试
 * @modified By：
 * @version: $
 */
public class SQLTest {
    public static void main(String[] args) {
        SQLParser<Car> parser = SQLParser.forPojoWithAttributes(Car.class, createAttributes(Car.class));
        IndexedCollection<Car> cars = new ConcurrentIndexedCollection<Car>();
        cars.addAll(CarFactory.createCollectionOfCars(10));

        ResultSet<Car> results = parser.retrieve(cars, "SELECT * FROM cars WHERE (" +
                "(manufacturer = 'Ford' OR manufacturer = 'Honda') " +
                "AND price <= 5000.0 " +
                "AND color NOT IN ('GREEN', 'WHITE')) " +
                "ORDER BY manufacturer DESC, price ASC");

        results.forEach(System.out::println); // Prints: Honda Accord, Ford Fusion, Ford Focus

    }
}
