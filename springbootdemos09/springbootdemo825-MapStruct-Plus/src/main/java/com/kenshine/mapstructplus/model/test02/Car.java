package com.kenshine.mapstructplus.model.test02;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@AutoMapper(target = CarDto.class)
public class Car {
    private String name;
    private String type;
    private SeatConfiguration seatConfiguration;
}
