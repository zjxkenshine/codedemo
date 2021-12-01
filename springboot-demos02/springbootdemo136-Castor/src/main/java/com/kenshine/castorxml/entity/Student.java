package com.kenshine.castorxml.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 10:09
 * @description：学生
 * @modified By：
 * @version: $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int rollno;
    private int age;
    private String firstname;
    private String lastname;
    private String nickname;
    private String marks;
}
