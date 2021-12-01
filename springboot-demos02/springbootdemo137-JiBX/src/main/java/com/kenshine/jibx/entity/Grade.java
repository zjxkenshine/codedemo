package com.kenshine.jibx.entity;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 10:31
 * @description：班级
 * @modified By：
 * @version: $
 */
public class Grade {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "students=" + students +
                '}';
    }
}
