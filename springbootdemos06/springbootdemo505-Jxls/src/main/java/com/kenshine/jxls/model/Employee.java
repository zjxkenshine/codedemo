package com.kenshine.jxls.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author by kenshine
 * @Classname Employee
 * @Description 测试类
 * @Date 2023-11-27 8:42
 * @modified By：
 * @version: 1.0$
 */
@Data
@Accessors(chain = true)
public class Employee {
    private String name;
    private Integer age;
    private Double payment;
    /**
     * 奖金
     */
    private Double bonus;
    private Date birthDate;
    public Employee(){
    }

    public Employee(String name,Date birthDate,Double payment,Double bonus){
        this.name=name;
        this.birthDate=birthDate;
        this.payment=payment;
        this.bonus=bonus;
    }
}
