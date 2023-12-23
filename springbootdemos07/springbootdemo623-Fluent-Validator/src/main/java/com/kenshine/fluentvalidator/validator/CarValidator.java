package com.kenshine.fluentvalidator.validator;

import com.baidu.unbiz.fluentvalidator.*;
import com.kenshine.fluentvalidator.model.Car;

import java.util.List;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * @author by kenshine
 * @Classname CarValidator
 * @Description 闭包传递 car验证
 * @Date 2023-12-23 10:10
 * @modified By：
 * @version: 1.0$
 */
public class CarValidator extends ValidatorHandler<Car> implements Validator<Car> {
    @Override
    public boolean validate(ValidatorContext context, Car car) {
        // 闭包
        Closure<List<String>> closure = context.getClosure("manufacturerClosure");
        List<String> manufacturers = closure.executeAndGetResult();

        if (!manufacturers.contains(car.getManufacturer())) {
            context.addErrorMsg("出错了："+car.getManufacturer());
            return false;
        }

        return FluentValidator.checkAll()
                .on(car.getLicensePlate(), new CarLicensePlateValidator())
                .on(car.getSeatCount(), new CarSeatCountValidator())
                .doValidate().result(toSimple()).isSuccess();
    }

}
