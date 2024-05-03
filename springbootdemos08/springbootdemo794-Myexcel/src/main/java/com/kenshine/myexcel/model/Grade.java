package com.kenshine.myexcel.model;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import com.github.liaochong.myexcel.core.annotation.MultiColumn;
import lombok.Data;

import java.util.List;

/**
 * @author kenshine
 * 一对多导入
 */
@Data
public class Grade {
    @ExcelColumn(index=0)
    private String gradeName;

    @MultiColumn(classType=Student.class)
    private List<Student> students;
}

