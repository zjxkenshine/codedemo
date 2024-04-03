package com.kenshine.jacksonprotobuf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kenshine
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    public String name;
    public int age;
    public String[] emails;
    public Employee boss;
}