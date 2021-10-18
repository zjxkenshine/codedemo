package com.kenshine.demo03.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kenshine.demo03.domain.Student;
import com.kenshine.demo03.mapper.StudentMapper;
import com.kenshine.demo03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 11:17
 * @description：学生业务实现
 * @modified By：
 * @version: $
 */
@Service
public class StudentServiceImpl implements StudentService {
    /**
     * 使用@AutoWire报错 https://www.pianshen.com/article/17361335489/
     * @Resource
     */
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAll(Integer pageNum, Integer pageSize) {
        //在查询之前设置分页,利用Mybatis的分页插件实现分页
        PageHelper.startPage(pageNum, pageSize);

        List<Student> list = studentMapper.getAll();
        PageInfo<Student> info = new PageInfo<>(list);
        return info.getList();
    }

    @Override
    public List<Student> getAll2(Integer pageNum, Integer pageSize) {
        //在查询之前设置分页,利用Mybatis的分页插件实现分页
        PageHelper.startPage(pageNum, pageSize);

        List<Student> list = studentMapper.getAll2();
        PageInfo<Student> info = new PageInfo<>(list);
        return info.getList();
    }

    @Override
    public Student get(Integer id) {
        return studentMapper.getById(id);
    }
}
