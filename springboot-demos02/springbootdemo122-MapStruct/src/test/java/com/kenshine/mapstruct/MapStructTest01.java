package com.kenshine.mapstruct;

import com.kenshine.mapstruct.domain.demo1.StudentDto;
import com.kenshine.mapstruct.domain.demo1.StudentVo;
import com.kenshine.mapstruct.mapper.MainMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 10:41
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapStructApp.class)
public class MapStructTest01 {

    @Autowired
    private MainMapper mainMapper;

    /**
     * 简单转换
     * lombok和mapstruct整合需要引入lombok-mapstruct-binding
     */
    @Test
    public void testSimpleMap() {
        StudentVo studentVo = StudentVo.builder()
                .school("家里蹲")
                .userId("123456")
                .userName("kenshine")
                .age(25)
                .address("温州")
                .build();
        StudentDto studentDto = mainMapper.studentVo2Dto(studentVo);
        System.out.println(studentDto);
    }

    /**
     * 不同字段转换
     */
    @Test
    public void test02() {
        StudentVo studentVo = StudentVo.builder()
                .school("家里蹲")
                .userId("123456")
                .userName("kenshine")
                .age(25)
                .address("温州")
                .emailAddress("123456@163.com")
                .build();
        StudentDto studentDto = mainMapper.studentVo2Dto(studentVo);
        System.out.println(studentDto);
    }

    /**
     * 列表转换
     */
    @Test
    public void test03() {
        List<StudentVo> studentVos = new ArrayList<>();
        StudentVo studentVo1 = StudentVo.builder()
                .school("家里蹲")
                .userId("123456")
                .userName("kenshine")
                .age(25)
                .address("温州")
                .emailAddress("123456@163.com")
                .build();

        StudentVo studentVo2 = StudentVo.builder()
                .school("哈佛")
                .userId("11223344")
                .userName("qin")
                .age(25)
                .address("上海")
                .emailAddress("11223344@163.com")
                .build();

        studentVos.add(studentVo1);
        studentVos.add(studentVo2);

        List<StudentDto> studentDtos = mainMapper.studentListVo2Dto(studentVos);
        System.out.println(studentDtos);
    }






}
