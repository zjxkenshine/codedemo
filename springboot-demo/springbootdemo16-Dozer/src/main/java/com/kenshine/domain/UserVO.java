package com.kenshine.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 10:19
 * @description：@Mapping注解测试
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@Data
public class UserVO {
    private Long userId;
    private String userName;
    private Integer userAge;
    private String gender;
    private String email;
    /**
     * 简单注解方式不能转换LocalDate
     */
    private Date birthday;
}
