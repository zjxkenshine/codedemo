package com.kenshine.beanutils.bean;

import com.kenshine.beanutils.convertor.DateConvertor;
import com.tuyang.beanutils.annotation.BeanCopySource;
import com.tuyang.beanutils.annotation.CopyCollection;
import com.tuyang.beanutils.annotation.CopyProperty;
import lombok.Data;

import java.util.List;

/**
 * @author by kenshine
 * @Classname UserVo
 * @Description 测试
 * @Date 2023-11-01 12:41
 * @modified By：
 * @version: 1.0$
 */
@Data
@BeanCopySource(source=User.class)
public class UserVo {
    private Long id;
    @CopyProperty(property="username")
    private String name;
    private Integer age;
    @CopyProperty(convertor= DateConvertor.class)
    private String time;

    @CopyProperty
    private Student firstStu;

//    从bean复制失败
//    @CopyProperty(property="firstStu.name")
//    private Student firstStuName;

    @CopyCollection(targetClass=StudentVo.class)
    private List<Student> students;
}
