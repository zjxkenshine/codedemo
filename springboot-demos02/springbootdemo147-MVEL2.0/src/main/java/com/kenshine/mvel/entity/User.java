package com.kenshine.mvel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 16:16
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
    private Integer age;
    private User parent;
    private List<User> familys;
}
