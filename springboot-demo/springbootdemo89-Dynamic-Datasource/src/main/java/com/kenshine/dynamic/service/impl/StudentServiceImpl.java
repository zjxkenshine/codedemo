package com.kenshine.dynamic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenshine.dynamic.entity.Student;
import com.kenshine.dynamic.mapper.StudentMapper;
import com.kenshine.dynamic.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 10:55
 * @description：学生业务实现
 * @modified By：
 * @version: $
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
