package com.kenshine.cqengine.domain.demo2;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 14:40
 * @description：汽车类2
 * @modified By：
 * @version: $
 */
public class Car {
    public enum Color {RED, GREEN, BLUE, BLACK, WHITE}
    final int carId;
    final String manufacturer;
    final String model;
    final Color color;
    final int doors;
    final double price;
    final List<String> features;

    public Car(int carId, String manufacturer, String model, Color color, int doors, double price, List<String> features) {
        this.carId = carId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.doors = doors;
        this.price = price;
        this.features = features;
    }

    public int getCarId() {
        return carId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", doors=" + doors +
                ", price=" + price +
                ", features=" + features +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Car)) { return false; }

        Car car = (Car) o;

        if (carId != car.carId) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return carId;
    }
}
