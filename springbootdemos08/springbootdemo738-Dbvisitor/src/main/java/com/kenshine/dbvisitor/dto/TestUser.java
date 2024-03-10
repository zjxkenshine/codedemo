package com.kenshine.dbvisitor.dto;

import lombok.Data;
import net.hasor.dbvisitor.mapping.Table;

import java.util.Date;

/**
 * @author kenshine
 * 驼峰转换
 */
@Table(mapUnderscoreToCamelCase = true)
@Data
public class TestUser {
  private Integer id;
  private String  name;
  private Integer age;
  private Date createTime;

}