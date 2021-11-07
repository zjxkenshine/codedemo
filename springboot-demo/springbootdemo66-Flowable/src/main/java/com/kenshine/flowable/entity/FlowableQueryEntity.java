package com.kenshine.flowable.entity;

import lombok.Data;

import java.util.List;

/**
 * Flowable 查询参数
 * @author: kenshine
 * @create: 2020-01-10 11:37
 **/
@Data
public class FlowableQueryEntity extends QueryEntity {

    // 审核人
    private String assignee;

    // 租户
    private String tenantId;

    // 租户列表
    private List<String> tenantList;

    // 流程定义Key 列表
    private List<String> processDefinitionKeyList;
}
