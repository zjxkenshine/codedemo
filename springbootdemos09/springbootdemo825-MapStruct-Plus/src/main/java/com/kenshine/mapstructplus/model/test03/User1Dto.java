package com.kenshine.mapstructplus.model.test03;

import com.kenshine.mapstructplus.converter.StringToListStringConverter;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
// 使用自定义转换器
@AutoMapper(target = User1.class, uses = StringToListStringConverter.class)
public class User1Dto {
    private String username;
    private int age;
    private boolean young;
    // 对应User1中的educationList
    @AutoMapping(target = "educationList")
    private String educations;
}