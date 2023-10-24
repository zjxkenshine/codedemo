package com.kenshine.autofactory.test03;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import lombok.ToString;

/**
 * @author by kenshine
 * @Classname User
 * @Description 自定义类名，非最终工厂
 * @Date 2023-10-24 8:57
 * @modified By：
 * @version: 1.0$
 *
 * className：自定义类名
 * allowSubclasses：非final工厂
 * implementing：生成的工厂指定要实现的接口列表
 */
@AutoFactory(className = "student",allowSubclasses=true,implementing = Students.class)
@ToString
public class User {
    private Integer id;

    private String name;

    User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
