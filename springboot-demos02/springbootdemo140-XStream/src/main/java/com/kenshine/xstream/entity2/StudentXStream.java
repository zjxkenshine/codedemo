package com.kenshine.xstream.entity2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:34
 * @description：学生(使用注解)
 * @modified By：
 * @version: $
 */
@XStreamAlias("student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentXStream {
    @XStreamAsAttribute
    private int rollno;
    @XStreamAsAttribute
    private int age;
    private String firstname;
    private String lastname;
    private String nickname;
    @XStreamOmitField
    private String marks;
}
