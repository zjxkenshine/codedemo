package com.kenshine.fluentvalidator.model;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;
import com.kenshine.fluentvalidator.validator.CarLicensePlateValidator;
import com.kenshine.fluentvalidator.validator.CarManufacturerValidator;
import com.kenshine.fluentvalidator.validator.CarSeatCountValidator;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Car3
 * @Description group
 * @Date 2023-12-23 10:07
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Car3 {
    /**
     * 分组校验
     */
    @FluentValidate(value = {CarManufacturerValidator.class}, groups = {Add.class})
    private String manufacturer;

    @FluentValidate({CarLicensePlateValidator.class})
    private String licensePlate;

    @FluentValidate({CarSeatCountValidator.class})
    private int seatCount;
}
