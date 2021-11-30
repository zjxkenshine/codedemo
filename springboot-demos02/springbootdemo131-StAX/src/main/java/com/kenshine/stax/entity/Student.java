package com.kenshine.stax.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 23:09
 * @description：
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
