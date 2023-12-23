package com.kenshine.fluentvalidator;

import com.baidu.unbiz.fluentvalidator.*;
import com.baidu.unbiz.fluentvalidator.registry.impl.SimpleRegistry;
import com.kenshine.fluentvalidator.model.Add;
import com.kenshine.fluentvalidator.model.Car;
import com.kenshine.fluentvalidator.model.Car2;
import com.kenshine.fluentvalidator.model.Car3;
import com.kenshine.fluentvalidator.validator.CarLicensePlateValidator;
import com.kenshine.fluentvalidator.validator.CarManufacturerValidator;
import com.kenshine.fluentvalidator.validator.CarSeatCountValidator;
import com.kenshine.fluentvalidator.validator.CarValidator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.*;

/**
 * @author by kenshine
 * @Classname FluentTest
 * @Description 使用测试
 * @Date 2023-12-23 9:26
 * @modified By：
 * @version: 1.0$
 */
public class FluentTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        Car car = getCar();
        Result ret = FluentValidator.checkAll()
                // 设置字段与校验器
                .on(car.getLicensePlate(), new CarLicensePlateValidator())
                .on(car.getManufacturer(), new CarManufacturerValidator())
                .on(car.getSeatCount(), new CarSeatCountValidator())
                .doValidate().result(toSimple());
        System.out.println(ret);
    }

    /**
     * 复杂结果
     */
    @Test
    public void test02(){
        Car car = getCar();
        ComplexResult ret = FluentValidator.checkAll()
                // 设置字段与校验器
                .on(car.getLicensePlate(), new CarLicensePlateValidator())
                .on(car.getManufacturer(), new CarManufacturerValidator())
                .on(car.getSeatCount(), new CarSeatCountValidator())
                .doValidate().result(toComplex());
        System.out.println(ret);
    }

    /**
     * 注解设置校验器
     */
    @Test
    public void test03(){
        Car2 car = getCar2();
        Result ret = FluentValidator.checkAll().configure(new SimpleRegistry())
                .on(car)
                .doValidate()
                .result(toSimple());
        System.out.println(ret);
    }

    /**
     * 分组校验
     */
    @Test
    public void test04(){
        Car3 car = getCar3();
        Result ret = FluentValidator.checkAll(new Class<?>[] {Add.class})
                .on(car)
                .doValidate()
                .result(toSimple());
        System.out.println(ret);
    }

    /**
     * 闭包传递校验
     */
    @Test
    public void test05(){
        Car car = getCar();
        Closure<List<String>> closure = new ClosureHandler<List<String>>() {
            private List<String> allManufacturers;
            @Override
            public List<String> getResult() {
                return allManufacturers;
            }
            @Override
            public void doExecute(Object... input) {
                allManufacturers = getAllManufacturers();
            }
        };
        // 校验链
        ValidatorChain chain = new ValidatorChain();
        List<Validator> validators = new ArrayList<>();
        validators.add(new CarValidator());
        chain.setValidators(validators);

        Result ret = FluentValidator.checkAll()
                .putClosure2Context("manufacturerClosure", closure)
                .on(car, chain)
                .doValidate().result(toSimple());
        System.out.println(ret);
        System.out.println(closure.getResult());
    }

    private List<String> getAllManufacturers() {
        return Arrays.asList("ST","BMW","QQ","BZ");
    }


    private Car getCar(){
        Car car=new Car();
        car.setSeatCount(1);
        car.setManufacturer("ST");
        car.setLicensePlate("浙A12345");
        return car;
    }

    private Car2 getCar2(){
        Car2 car=new Car2();
        car.setSeatCount(1);
        car.setManufacturer("ST");
        car.setLicensePlate("浙A12345");
        return car;
    }

    private Car3 getCar3(){
        Car3 car=new Car3();
        car.setSeatCount(1);
        car.setManufacturer("ST");
        car.setLicensePlate("浙A12345");
        return car;
    }
}
