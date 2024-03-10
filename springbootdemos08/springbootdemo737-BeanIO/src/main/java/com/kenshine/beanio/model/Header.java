package com.kenshine.beanio.model;

import lombok.Data;

import java.util.Date;

/**
 * @author by kenshine
 * @Classname Header
 * @Description 表头
 * @Date 2024-03-10 10:15
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Header {
    private String recordType;
    private Date fileDate;
}
