package com.kenshine.demo01.model;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/14 22:24
 * @description：
 * @modified By：
 * @version: $
 * 员工类
 * 内部bean注入
 */
public class Emp {
    private String ename;
    private String gender;
    //员工属于某一个部门，使用对象形式表示
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void show(){
        System.out.println(dept);
    }
}
