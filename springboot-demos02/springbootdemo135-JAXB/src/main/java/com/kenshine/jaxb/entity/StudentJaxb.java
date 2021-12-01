package com.kenshine.jaxb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 9:43
 * @description：学生
 * @modified By：
 * @version: $
 */
@XmlType(propOrder = {"marks", "firstname", "lastname", "nickname"})
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentJaxb {

    @XmlAttribute
    private int rollno;
    @XmlAttribute(namespace = "http://www.w3.org/TR/html4/school/")
    private int age;
    @XmlElement(namespace = "http://www.w3.org/TR/html4/school/")
    private String firstname;
    private String lastname;
    private String nickname;
    private String marks;
}
