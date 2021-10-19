package com.kenshine.pattern.prototype.test;

/**
 * @version v1.0
 * @ClassName: Student
 * @Description:
 * @Author: 黑马程序员
 */
public class Student {

    //学生的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
