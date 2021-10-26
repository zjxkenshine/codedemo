package com.kenshine.domain;

import com.github.dozermapper.core.Mapping;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 10:17
 * @description：@Mapper注解测试
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@Data
public class UserEntity {
    @Mapping(value = "userId")
    private Long id;
    @Mapping(value = "userName")
    private String name;
    @Mapping(value = "userAge")
    private Integer age;
    private String gender;
    private String email;
    @Mapping(value = "birthday")
    private String birthday;
}
