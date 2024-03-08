package com.kenshine.jsapar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 测试类
 * @author kenshine
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private int employeeNumber;
    private Address address;
    private LocalDate birthDate;
}