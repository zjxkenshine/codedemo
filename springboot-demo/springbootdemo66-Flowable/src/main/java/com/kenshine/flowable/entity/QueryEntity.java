package com.kenshine.flowable.entity;

import lombok.Data;

import java.util.Date;

/**
 * 查询参数实体类
 * @author: kenshine
 * @create: 2020-01-10 11:34
 **/
@Data
public class QueryEntity {

    //关键字
    private String keyword;

    // 页数
    private Integer page;

    // 条数
    private Integer limit;

    // 开始时间
    private Date startTime;

    // 结束时间
    private Date endTime;
}
