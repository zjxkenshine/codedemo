package com.kenshine.drools.demo01.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 16:36
 * @description：学生
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class Student {
    private int id;
    private String name;
    private int age;
}
