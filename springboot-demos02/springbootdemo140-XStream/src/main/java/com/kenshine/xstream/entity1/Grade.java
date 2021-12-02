package com.kenshine.xstream.entity1;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:32
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
