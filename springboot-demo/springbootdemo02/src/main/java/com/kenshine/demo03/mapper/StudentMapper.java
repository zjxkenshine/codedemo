package com.kenshine.demo03.mapper;

import com.kenshine.demo03.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 11:13
 * @description：学生Mapper
 * @modified By：
 * @version: 1.0$
 */
public interface StudentMapper {


    List<Student> getAll();

    Student getById(@Param("id") int id);

    /**
     * 以注解的方式实现ssm整合
     */
    @Select("SELECT * FROM student")
    List<Student> getAll2();
}
