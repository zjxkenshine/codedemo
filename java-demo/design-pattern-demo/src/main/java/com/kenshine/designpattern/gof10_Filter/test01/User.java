package com.kenshine.designpattern.gof10_Filter.test01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/1 19:51
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private String name;
    private Boolean vip;
    private Integer age;
}
