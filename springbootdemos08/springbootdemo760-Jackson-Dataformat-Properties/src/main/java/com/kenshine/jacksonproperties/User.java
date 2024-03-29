package com.kenshine.jacksonproperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户
 * @Date 2024-03-29 10:37
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Address address;
}
