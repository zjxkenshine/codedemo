package com.kenshine.demo01.autowire;

import lombok.Data;

@Data
public class Emp {
    private String ename;
    private String gender;
    //员工属于某一个部门，使用对象形式表示
    private Dept dept;
}