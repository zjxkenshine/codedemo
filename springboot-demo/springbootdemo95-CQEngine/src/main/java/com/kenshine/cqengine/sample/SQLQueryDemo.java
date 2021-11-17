package com.kenshine.cqengine.sample;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.parser.sql.SQLParser;
import com.googlecode.cqengine.resultset.ResultSet;
import com.kenshine.cqengine.domain.demo2.Car;
import com.kenshine.cqengine.domain.demo2.CarFactory;

import java.util.Map;

import static com.googlecode.cqengine.codegen.AttributeBytecodeGenerator.createAttributes;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 14:44
 * @description：SQL+Index 的demo
 * @modified By：
 * @version: $
 *
 */
public class SQLQueryDemo {

    public static void main(String[] args) {
        Map<String, ? extends Attribute<Car, ?>> attributesMap =  createAttributes(Car.class);
        SQLParser<Car> parser = SQLParser.forPojoWithAttributes(Car.class, attributesMap);
        IndexedCollection<Car> cars = new ConcurrentIndexedCollection<Car>();
        cars.addIndex(HashIndex.onAttribute((Attribute<Car, String>) attributesMap.get("manufacturer")));
        cars.addIndex(NavigableIndex.onAttribute((Attribute<Car, String>) attributesMap.get("price")));
        cars.addIndex(HashIndex.onAttribute((Attribute<Car, String>) attributesMap.get("color")));

        cars.addAll(CarFactory.createCollectionOfCars(10));


        ResultSet<Car> results = parser.retrieve(cars, "SELECT * FROM cars WHERE (" +
                "(manufacturer = 'Ford' OR manufacturer = 'Honda') " +
                "AND price <= 5000.0 " +
                "AND color NOT IN ('GREEN', 'WHITE')) " +
                "ORDER BY manufacturer DESC, price ASC");
        System.out.println("results.getRetrievalCost()=" + results.getRetrievalCost());
        System.out.println("results.getMergeCost()=" + results.getMergeCost());
        results.forEach(System.out::println); // Prints: Honda Accord, Ford Fusion, Ford Focus
    }
}
