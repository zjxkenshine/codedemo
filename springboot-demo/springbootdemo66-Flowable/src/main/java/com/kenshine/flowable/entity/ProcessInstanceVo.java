package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.engine.runtime.ProcessInstance;

import java.util.Date;
import java.util.Map;

/**
 * ProcessInstanceVo
 * @author: kenshine
 * @create: 2020-01-02 14:15
 **/
@Data
public class ProcessInstanceVo {

    private String id;

    private String processDefinitionKey;

    private String processDefinitionId;

    private String businessKey;

    private String processDefinitionName;

    private Date startTime;

    private String deploymentId;

    private String description;

    private String name;

    private Integer processDefinitionVersion;

    private Map<String, Object> processVariables;

    private String startUserId;

    private String callbackId;

    private String callbackType;

    private String tenantId;

    private String localizedDescription;

    private String localizedName;

    private String processInstanceId;

    private String activityId;

    private String parentId;

    private String rootProcessInstanceId;

    private String superExecutionId;

    private Boolean isSuspended;

    private Boolean isEnded;

    public ProcessInstanceVo(){}

    public ProcessInstanceVo(ProcessInstance processInstance){
        id = processInstance.getId();
        processDefinitionKey = processInstance.getProcessDefinitionKey();
        processDefinitionId = processInstance.getProcessDefinitionId();
        businessKey = processInstance.getBusinessKey();
        processDefinitionName = processInstance.getProcessDefinitionName();
        startTime = processInstance.getStartTime();
        deploymentId = processInstance.getDeploymentId();
        description = processInstance.getDescription();
        name = processInstance.getName();
        processDefinitionVersion = processInstance.getProcessDefinitionVersion();
        processVariables = processInstance.getProcessVariables();
        startUserId = processInstance.getStartUserId();
        callbackId = processInstance.getCallbackId();
        callbackType = processInstance.getCallbackType();
        tenantId = processInstance.getTenantId();
        localizedDescription = processInstance.getLocalizedDescription();
        localizedName = processInstance.getLocalizedName();
        processInstanceId = processInstance.getProcessInstanceId();
        activityId = processInstance.getActivityId();
        parentId = processInstance.getParentId();
        rootProcessInstanceId = processInstance.getRootProcessInstanceId();
        superExecutionId = processInstance.getSuperExecutionId();
        isSuspended = processInstance.isSuspended();
        isEnded = processInstance.isEnded();
    }
}
