package com.kenshine.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 9:27
 * @description：用户
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@Data
public class User {
    //字段名不同
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String email;
    //LocalDateTime需要转为String
    private LocalDateTime birthday;
}
