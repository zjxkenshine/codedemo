package com.kenshine.dynamic.entity;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 10:41
 * @description：学生
 * @modified By：
 * @version: $
 */
@Data
@TableName(value = "student")
public class Student {

    private Integer id;
    private String name;
    private Integer age;

}
