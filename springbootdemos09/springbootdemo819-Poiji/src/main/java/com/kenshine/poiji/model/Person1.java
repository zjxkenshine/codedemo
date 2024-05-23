package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCell;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Person1
 * @Description 自定义cast实现
 * @Date 2024-05-23 12:02
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Person1 {
    @ExcelCell(0)
    protected String employeeId;

    @ExcelCell(1)
    protected String name;

    @ExcelCell(2)
    protected String surname;
}
