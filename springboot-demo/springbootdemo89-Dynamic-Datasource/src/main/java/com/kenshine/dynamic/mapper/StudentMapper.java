package com.kenshine.dynamic.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kenshine.dynamic.entity.Student;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 10:51
 * @description：学生Mapper
 * @modified By：
 * @version: $
 * //@DS("slave1")配置多数据源
 * 可以在类上也可以在方法上，类>方法
 */
@DS("slave1")
public interface StudentMapper extends BaseMapper<Student>{

}


