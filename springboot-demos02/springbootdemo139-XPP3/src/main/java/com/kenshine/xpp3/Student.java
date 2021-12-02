package com.kenshine.xpp3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:15
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
