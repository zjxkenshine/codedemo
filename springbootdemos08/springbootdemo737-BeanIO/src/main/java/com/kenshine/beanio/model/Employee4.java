package com.kenshine.beanio.model;

import lombok.Data;

import java.util.Date;

/**
 * @author kenshine
 * 测试类
 */
@Data
public class Employee4 {
    String recordType;
    String firstName;
    String lastName;
    String title;
    int salary;
    Date hireDate;
}