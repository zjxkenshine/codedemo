package com.kenshine.objectcomparator.model;

import idea.verlif.comparator.CompareField;
import lombok.Data;

import java.util.Date;

/**
 * @author by kenshine
 * @Classname Student
 * @Description 测试类
 * @Date 2024-05-08 8:35
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Student {
    private Date birthday;
    private Pet pet;
}
