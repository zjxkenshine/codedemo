package com.kenshine.demo03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 11:12
 * @description：学生实体
 * @modified By：
 * @version: 1.0$
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private String sex;

}
