package com.kenshine.javers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.javers.core.metamodel.annotation.Id;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Student
 * @Description 测试类
 * @Date 2023-11-17 8:22
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Student {
    @Id
    private int id;
    private String name;
    private int age;
    List<Teacher> teachers;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
