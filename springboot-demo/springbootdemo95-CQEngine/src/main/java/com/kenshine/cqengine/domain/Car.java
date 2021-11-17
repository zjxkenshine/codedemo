package com.kenshine.cqengine.domain;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 14:32
 * @description：汽车
 * @modified By：
 * @version: $
 */
public class Car {
    public final int carId;
    public final String name;
    public final String description;
    public final List<String> features;

    public Car(int carId, String name, String description, List<String> features) {
        this.carId = carId;
        this.name = name;
        this.description = description;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Car{carId=" + carId + ", name='" + name + "', description='" + description + "', features=" + features + "}";
    }

    // -------------------------- Attributes --------------------------
    public static final Attribute<Car, Integer> CAR_ID = new SimpleAttribute<Car, Integer>("carId") {
        public Integer getValue(Car car, QueryOptions queryOptions) { return car.carId; }
    };

    public static final Attribute<Car, String> NAME = new SimpleAttribute<Car, String>("name") {
        public String getValue(Car car, QueryOptions queryOptions) { return car.name; }
    };

    public static final Attribute<Car, String> DESCRIPTION = new SimpleAttribute<Car, String>("description") {
        public String getValue(Car car, QueryOptions queryOptions) { return car.description; }
    };

    public static final Attribute<Car, String> FEATURES = new MultiValueAttribute<Car, String>("features") {
        public List<String> getValues(Car car, QueryOptions queryOptions) { return car.features; }
    };
}
