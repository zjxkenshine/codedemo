package com.kenshine.beanutils.bean;

import com.tuyang.beanutils.annotation.CopyCollection;
import com.tuyang.beanutils.annotation.CopyProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author by kenshine
 * @Classname User
 * @Description 测试
 * @Date 2023-11-01 12:41
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private Integer age;
    private LocalDateTime time;


    private Student firstStu;

    private List<Student> students;
}
