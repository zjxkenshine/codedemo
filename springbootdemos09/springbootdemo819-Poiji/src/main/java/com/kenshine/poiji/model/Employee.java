package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kenshine
 * 不需要getter 与 setter 方法就可以映射
 */
@Data
public class Employee {
    @ExcelRow
    private int rowIndex;

    @ExcelCell(0)
    private long employeeId;

    @ExcelCell(1)
    private String name;

    @ExcelCell(2)
    private String surname;

    @ExcelCell(3)
    private int age;

    @ExcelCell(4)
    private boolean single;

    @ExcelCellName("emails")
    List<String> emails;

    @ExcelCell(5)
    List<BigDecimal> bills;
}