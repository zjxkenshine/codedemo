package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.task.api.Task;

import java.util.Date;
import java.util.Map;

/**
 * TaskVo
 * @author: kenshine
 * @create: 2020-01-02 10:44
 **/
@Data
public class TaskVo {

    private String id;

    private String executionId;

    private String parentTaskId;

    private String processDefinitionId;

    private String processInstanceId;

    private String assignee;

    private String category;

    private Date claimTime;

    private Date createTime;

    private Date dueDate;

    private String description;

    private String formKey;

    private String name;

    private String owner;

    private Integer priority;

    private Map<String, Object> processVariables;

    private Map<String, Object> taskLocalVariables;

    private String scopeId;

    private String scopeDefinitionId;

    private String scopeType;

    private String subScopeId;

    private String taskDefinitionId;

    private String taskDefinitionKey;

    private String tenantId;

    private Boolean isSuspended;

    // 额外添加
    private ProcessInstanceVo processInstance;

    public TaskVo(){}

    public TaskVo(Task task) {
        id = task.getId();
        executionId = task.getExecutionId();
        parentTaskId = task.getParentTaskId();
        processInstanceId = task.getProcessInstanceId();
        assignee = task.getAssignee();
        category = task.getCategory();
        claimTime = task.getClaimTime();
        createTime = task.getCreateTime();
        description = task.getDescription();
        dueDate = task.getDueDate();
        formKey = task.getFormKey();
        name = task.getName();
        owner = task.getOwner();
        priority = task.getPriority();
        processDefinitionId = task.getProcessDefinitionId();
        processVariables = task.getProcessVariables();
        scopeDefinitionId = task.getScopeDefinitionId();
        scopeId = task.getScopeId();
        scopeType = task.getScopeType();
        subScopeId = task.getSubScopeId();
        taskDefinitionId = task.getTaskDefinitionId();
        taskDefinitionKey = task.getTaskDefinitionKey();
        taskLocalVariables = task.getTaskLocalVariables();
        tenantId = task.getTenantId();
        isSuspended = task.isSuspended();
    }
}
