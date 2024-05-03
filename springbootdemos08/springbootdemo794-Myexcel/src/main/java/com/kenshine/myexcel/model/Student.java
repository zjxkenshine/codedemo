package com.kenshine.myexcel.model;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import lombok.Data;

/**
 * @author 一对多导入
 */
@Data
public class Student {
   @ExcelColumn(index=1)
   private String name;

   @ExcelColumn(index=2)
   private Integer age;
}