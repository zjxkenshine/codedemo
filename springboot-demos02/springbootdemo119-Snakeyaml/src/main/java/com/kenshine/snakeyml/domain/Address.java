package com.kenshine.snakeyml.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 17:50
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String line;
    private String city;
    private String state;
    private Integer zip;
}
