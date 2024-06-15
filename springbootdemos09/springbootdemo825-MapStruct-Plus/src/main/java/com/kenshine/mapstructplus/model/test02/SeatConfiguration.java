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
@AutoMapper(target = SeatConfigurationDto.class)
public class SeatConfiguration {
    private String name;
    private Integer price;
}
