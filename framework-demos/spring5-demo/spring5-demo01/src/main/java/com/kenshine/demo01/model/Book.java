package com.kenshine.demo01.model;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/14 21:38
 * @description：
 * @modified By：
 * @version: $
 */
//（1）传统方式： 创建类，定义属性和对应的set方法
@Data
public class Book {
    //创建属性
    private String bname;
    private String bauthor;
    private String address;
}
