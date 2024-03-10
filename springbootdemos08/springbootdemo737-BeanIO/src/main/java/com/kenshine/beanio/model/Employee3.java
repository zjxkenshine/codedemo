package com.kenshine.beanio.model;

import lombok.Data;
import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

import java.util.Date;

/**
 * @author by kenshine
 * @Classname Employee3
 * @Description 注解方式
 * @Date 2024-03-10 10:04
 * @modified By：
 * @version: 1.0$
 */
@Record(minOccurs=1)
@Fields({
        // 行标识 EMP
    @Field(name="type", at=0, rid=true, literal="EMP")
})
@Data
public class Employee3 {
    @Field(at=1)
    private String firstName;
    @Field(at=2)
    private String lastName;
    @Field(at=3)
    private String title;
    @Field(at=4)
    private String salary;
    @Field(at=5, format="MMddyyyy")
    private Date hireDate;
}
