package com.kenshine.myexcel.model;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname People
 * @Description 测试类
 * @Date 2024-05-03 10:30
 * @modified By：
 * @version: 1.0$
 */
@Data
public class People {
    @ExcelColumn(order = 0, title = "姓名")
    private String name;

    @ExcelColumn(order = 1, title = "年龄")
    private Integer age;

    @ExcelColumn(order = 2, title = "性别")
    private String gender;
}
