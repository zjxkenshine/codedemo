package com.kenshine.myexcel.model;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname TestDO
 * @Description 测试do
 * @Date 2024-05-03 10:24
 * @modified By：
 * @version: 1.0$
 */
@Data
public class TestDO {
    @ExcelColumn(title="姓名",groups={People.class})
    private String name;

    @ExcelColumn(title="年龄")
    private Integer age;
}
