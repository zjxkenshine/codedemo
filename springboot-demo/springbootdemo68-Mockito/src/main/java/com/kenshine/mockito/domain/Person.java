package com.kenshine.mockito.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 11:35
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    private int id;
    private String name;


}
