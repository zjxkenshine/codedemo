package com.kenshine.mapstructplus.model.test02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CarDto {
    private String name;
    private String type;
    private SeatConfiguration seatConfiguration;
}