package com.kenshine.mapstruct.mapper;

import com.kenshine.mapstruct.domain.demo1.StudentDto;
import com.kenshine.mapstruct.domain.demo1.StudentVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 10:38
 * @description：对象转换器
 * @modified By：
 * @version: $
 *
 * 会自动编译生成实现类
 */
@Mapper(componentModel = "spring")
public interface MainMapper {
    /**不同字段映射*/
    @Mapping(source = "emailAddress", target = "email")
    StudentDto studentVo2Dto(StudentVo vo);

    /**
     * List转换
     * @param vo
     * @return
     */
    List<StudentDto> studentListVo2Dto(List<StudentVo> vo);
}
