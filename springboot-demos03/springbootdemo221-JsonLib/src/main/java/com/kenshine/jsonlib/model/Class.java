package com.kenshine.jsonlib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 8:49
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    private String name;
    private Date date;
    private List<Student> students;
}
