package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCellName;

/**
 * @author kenshine
 * ExcelCellName指定表头
 */
public class Person {

    @ExcelCellName("Name")
    protected String name;

    @ExcelCellName("Address")
    protected String address;

    @ExcelCellName("Age")
    protected int age;

    @ExcelCellName("Email")
    protected String email;

    // 同义词
    @ExcelCellName(value = "", expression = "Surname|Second name")
    private String surname;

}