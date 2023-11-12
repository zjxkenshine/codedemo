package com.kenshine.csv.model;

import com.github.houbb.csv.annotation.Csv;
import com.kenshine.csv.converter.ReadDateConvert;
import com.kenshine.csv.converter.WriteDateConvert;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * CSV注解
 * @author Kenshine
 */
@Data
@Accessors(chain = true)
public class UserAnnotation {

    @Csv(label = "名称")
    private String name;

    @Csv(label = "密码", readRequire = false, writeRequire = false)
    private String password;

    @Csv(label = "生日", readConverter = ReadDateConvert.class, writeConverter = WriteDateConvert.class)
    private Date birthday;
    /**
     * 枚举映射
     */
    @Csv(readMapping = "S:成功;F:失败", writeMapping = "S:成功;F:失败")
    private String status;

}