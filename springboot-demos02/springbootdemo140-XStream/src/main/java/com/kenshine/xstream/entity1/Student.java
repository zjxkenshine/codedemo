package com.kenshine.xstream.entity1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:32
 * @description：学生
 * @modified By：
 * @version: $
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int rollno;
    private int age;
    private String firstname;
    private String lastname;
    private String nickname;
    private String marks;
}
