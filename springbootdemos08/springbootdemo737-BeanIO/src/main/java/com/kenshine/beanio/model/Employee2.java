package com.kenshine.beanio.model;

import lombok.Data;

import java.util.Date;

/**
 * @author by kenshine
 * @Classname Employee2
 * @Description 嵌套bean
 * @Date 2024-03-10 9:28
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Employee2 {
    String firstName;
    String lastName;
    String title;
    int salary;
    Date hireDate;
    Address mailingAddress;
}
