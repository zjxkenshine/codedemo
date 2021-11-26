package com.kenshine.snakeyml.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 17:45
 * @description：测试对象
 * @modified By：
 * @version: $
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String firstName;
    private String lastName;
    private int age;
}
