package com.kenshine.mapstructplus.model.test03;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AutoMapper(target = User1Dto.class)
public class User1 {
    private String username;
    private int age;
    private boolean young;
    private List<String> educationList;
}