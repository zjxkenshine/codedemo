package com.kenshine.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 9:28
 * @description：用户DTO
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private Integer userAge;
    private String gender;
    private String email;
    private String birthday;
}
