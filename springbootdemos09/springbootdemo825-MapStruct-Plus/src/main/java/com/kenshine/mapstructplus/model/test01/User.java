package com.kenshine.mapstructplus.model.test01;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@AutoMapper(target = UserDto.class)
public class User {
    private String username;
    private int age;
    private boolean young;
}