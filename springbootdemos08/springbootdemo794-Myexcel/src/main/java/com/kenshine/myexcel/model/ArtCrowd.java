package com.kenshine.myexcel.model;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import lombok.Data;

import java.util.Date;

/**
 * @author kenshine
 * 测试类
 */
@Data
public class ArtCrowd {
    // index代表列索引，从0开始
    @ExcelColumn(index = 0)
    private String name;

    @ExcelColumn(index = 1)
    private Integer age;

    @ExcelColumn(index = 2,format="yyyy-MM-dd")
    private Date birthday;

    @ExcelColumn(index = 3)
    private Boolean dance;

    public boolean isDance() {
        return dance;
    }
}