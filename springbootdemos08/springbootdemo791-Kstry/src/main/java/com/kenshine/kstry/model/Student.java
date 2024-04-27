package com.kenshine.kstry.model;

import lombok.Data;

/**
 * @author by kenshine
 * @Classname Student
 * @Description 学生全量信息
 * @Date 2024-04-27 9:02
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Student {
    private Long id;
    private String name;
    private String address;
    private String idCard;
    private String birthday;
}
