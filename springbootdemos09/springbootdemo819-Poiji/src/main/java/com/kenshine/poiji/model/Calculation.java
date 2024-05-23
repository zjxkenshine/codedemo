package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCell;
import lombok.Data;

/**
 * @author kenshine
 * consumer接口支持
 */
@Data
public class Calculation {

  @ExcelCell(0)
  String name;

  @ExcelCell(1)
  int a;

  @ExcelCell(2)
  int b;

}