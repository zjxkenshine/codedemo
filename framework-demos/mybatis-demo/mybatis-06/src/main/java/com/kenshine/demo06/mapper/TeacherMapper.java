package com.kenshine.demo06.mapper;

import com.kenshine.demo06.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher where id =#{tid}")
    Teacher getTeacher(@Param("tid") int id);

}
