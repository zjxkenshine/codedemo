package com.kenshine.mapstruct.domain.demo2;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 10:55
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class Car {
    private Integer make;
    private Integer numberOfSeats;
    private Engine engine;

    private Integer price;
    private LocalDateTime createTime;
}
