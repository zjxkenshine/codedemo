package com.kenshine.drools.demo03.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 17:36
 * @description：计算工资
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class Calculation {
    private double wage;        //税前工资
    private double wagemore;    //应纳税所得额
    private double cess;        //税率
    private double preminus;    //速算扣除数
    private double wageminus;   //扣税额
    private double actualwage;  //税后工资
}
