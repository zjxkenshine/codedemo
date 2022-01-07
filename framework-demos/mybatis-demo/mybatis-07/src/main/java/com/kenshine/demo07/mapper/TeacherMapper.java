package com.kenshine.demo07.mapper;

import com.kenshine.demo07.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

//    List<Teacher> getTeacher();

    /**
     *  获取指定老师下的所有学生
     */
    Teacher getTeacher(@Param("id") int id);
    Teacher getTeacher2(@Param("id") int id);

}
