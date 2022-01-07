package com.kenshine.demo06.mapper;

import com.kenshine.demo06.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询用户列表
     */
    List<Student> getStudent();

    List<Student> getStudent2();
}
