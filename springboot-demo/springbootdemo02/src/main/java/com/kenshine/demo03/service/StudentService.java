package com.kenshine.demo03.service;

import com.kenshine.demo03.domain.Student;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 11:16
 * @description：学生业务实现
 * @modified By：
 * @version: 1.0$
 */
public interface StudentService {
    /**
     * 分页参数
     */
    List<Student> getAll(Integer pageNum, Integer pageSize);

    /**
     * 分页参数
     */
    List<Student> getAll2(Integer pageNum, Integer pageSize);

    Student get(Integer id);
}
