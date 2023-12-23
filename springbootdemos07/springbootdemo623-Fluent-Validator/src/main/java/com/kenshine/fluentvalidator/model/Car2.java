package com.kenshine.fluentvalidator.model;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;
import com.kenshine.fluentvalidator.validator.CarLicensePlateValidator;
import com.kenshine.fluentvalidator.validator.CarManufacturerValidator;
import com.kenshine.fluentvalidator.validator.CarSeatCountValidator;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Car2
 * @Description 注解设置校验器
 * @Date 2023-12-23 9:44
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Car2 {
    @FluentValidate({CarManufacturerValidator.class})
    private String manufacturer;

    @FluentValidate({CarLicensePlateValidator.class})
    private String licensePlate;

    @FluentValidate({CarSeatCountValidator.class})
    private int seatCount;
}
