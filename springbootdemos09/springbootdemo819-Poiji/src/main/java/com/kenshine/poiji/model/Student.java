package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelSheet;

/**
 * @author kenshine
 * 指定sheet名称
 */
@ExcelSheet("Sheet2")
public class Student {

    @ExcelCell(0)
    private String name;

    @ExcelCell(1)
    private String id;

    @ExcelCell(2)
    private String phone;


    @Override
    public String toString() {
        return "Student {" +
                " name=" + name +
                ", id=" + id + "'" +
                ", phone='" + phone + "'" +
                '}';
    }
}