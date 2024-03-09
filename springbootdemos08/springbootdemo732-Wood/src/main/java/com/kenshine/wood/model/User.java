package com.kenshine.wood.model;

import lombok.Data;
import org.noear.wood.annotation.PrimaryKey;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户类
 * @Date 2024-03-09 8:42
 * @modified By：
 * @version: 1.0$
 */
@Data
public class User {
    @PrimaryKey
    private Integer id;
    private String name;
}
