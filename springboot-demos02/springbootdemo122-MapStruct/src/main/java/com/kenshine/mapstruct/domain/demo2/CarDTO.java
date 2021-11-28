package com.kenshine.mapstruct.domain.demo2;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 10:55
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class CarDTO {
    private Integer manufacturer;
    private Integer seatCount;
    private EngineDTO engine;
 //   private PersonDTO person;

    private String price;
    private String createTime;
}
