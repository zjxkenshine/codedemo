package com.kenshine.fluentvalidator.model;

import lombok.Data;

/**
 * 测试类
 * @author Administrator
 */
@Data
public class Car {
    /**
     * 厂商
     */
    private String manufacturer;
    /**
     * 车牌
     */
    private String licensePlate;
    /**
     * 几座
     */
    private int seatCount;

}