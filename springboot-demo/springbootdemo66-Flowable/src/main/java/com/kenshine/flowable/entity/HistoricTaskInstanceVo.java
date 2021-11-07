package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.task.api.history.HistoricTaskInstance;

import java.util.Date;
import java.util.Map;

/**
 * HistoricTaskInstance
 * @author: kenshine
 * @create: 2020-02-03 16:27
 **/
@Data
public class HistoricTaskInstanceVo {

    private String id;

    private Date time;

    private String tenantId;

    private Map<String, Object> taskLocalVariables;

    private String taskDefinitionId;

    private String subScopeId;

    private String scopeType;

    private String scopeId;

    private String scopeDefinitionId;

    private Map<String, Object> processVariables;

    private String processInstanceId;

    private String processDefinitionId;

    private int priority;

    private String parentTaskId;

    private String owner;

    private String name;

    private String formKey;

    private String executionId;

    private Date dueDate;

    private String description;

    private String category;

    private String assignee;

    private Long workTimeInMillis;

    private Long durationInMillis;

    private Date claimTime;

    private Date endTime;

    private Date createTime;

    private String deleteReason;

    private String taskDefinitionKey;

    // 额外添加
    // 历史流程实例
    private HistoricProcessInstanceVo historicProcessInstance;

    public HistoricTaskInstanceVo(){}

    public HistoricTaskInstanceVo(HistoricTaskInstance historicTaskInstance) {
        id = historicTaskInstance.getId();
        time = historicTaskInstance.getTime();
        tenantId = historicTaskInstance.getTenantId();
        taskLocalVariables = historicTaskInstance.getTaskLocalVariables();
        taskDefinitionId = historicTaskInstance.getTaskDefinitionId();
        subScopeId = historicTaskInstance.getSubScopeId();
        scopeType = historicTaskInstance.getScopeType();
        scopeId = historicTaskInstance.getScopeId();
        scopeDefinitionId = historicTaskInstance.getScopeDefinitionId();
        processVariables = historicTaskInstance.getProcessVariables();
        processInstanceId = historicTaskInstance.getProcessInstanceId();
        processDefinitionId = historicTaskInstance.getProcessDefinitionId();
        priority = historicTaskInstance.getPriority();
        parentTaskId = historicTaskInstance.getParentTaskId();
        owner = historicTaskInstance.getOwner();
        name = historicTaskInstance.getName();
        formKey = historicTaskInstance.getFormKey();
        executionId = historicTaskInstance.getExecutionId();
        dueDate = historicTaskInstance.getDueDate();
        description = historicTaskInstance.getDescription();
        category = historicTaskInstance.getCategory();
        assignee = historicTaskInstance.getAssignee();
        workTimeInMillis = historicTaskInstance.getWorkTimeInMillis();
        durationInMillis = historicTaskInstance.getDurationInMillis();
        claimTime = historicTaskInstance.getClaimTime();
        endTime = historicTaskInstance.getEndTime();
        createTime = historicTaskInstance.getCreateTime();
        deleteReason = historicTaskInstance.getDeleteReason();
        taskDefinitionKey = historicTaskInstance.getTaskDefinitionKey();
    }
}
