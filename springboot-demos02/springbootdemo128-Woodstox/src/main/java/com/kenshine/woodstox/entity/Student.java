package com.kenshine.woodstox.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 15:32
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int rollno;
    private int age;
    private String firstname;
    private String lastname;
    private String nickname;
    private String marks;
}
