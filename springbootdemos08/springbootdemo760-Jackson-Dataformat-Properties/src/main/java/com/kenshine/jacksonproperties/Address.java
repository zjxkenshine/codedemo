package com.kenshine.jacksonproperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname Address
 * @Description 地址
 * @Date 2024-03-29 10:41
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String street;
}
