package com.kenshine.jxls.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname Department
 * @Description 部门
 * @Date 2023-11-27 9:31
 * @modified By：
 * @version: 1.0$
 */
@Data
@Accessors(chain = true)
public class Department {
    private String name;
    private Employee chief;
    private List<Employee> staff = new ArrayList<>();
    private String link;
}
