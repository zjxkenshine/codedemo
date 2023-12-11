package com.kenshine.immutator.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author by kenshine
 * @Classname User
 * @Description 测试类
 * @Date 2023-12-11 16:17
 * @modified By：
 * @version: 1.0$
 */
@Data
@Accessors(chain = true)
public class User {
    private String name;

    public boolean setTrueName(String name){
        this.name=name;
        return true;
    }
}
