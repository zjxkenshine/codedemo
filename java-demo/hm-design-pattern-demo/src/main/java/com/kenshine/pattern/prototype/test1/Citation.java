package com.kenshine.pattern.prototype.test1;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName: Citation
 * @Description: 奖状
 * @Author: 黑马程序员
 */
public class Citation implements Cloneable, Serializable {

    /*//三好学生上的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(stu.getName() + "同学：在2020学年第一学期中表现优秀，被评为三好学生。特发此状！");
    }
}
