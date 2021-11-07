package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.engine.history.HistoricProcessInstance;

import java.util.Date;
import java.util.Map;

/**
 * HistoricProcessInstanceVo
 * @author: kenshine
 * @create: 2020-01-02 13:54
 **/
@Data
public class HistoricProcessInstanceVo {

    private String id;

    private String processDefinitionId;

    private String businessKey;

    private String processDefinitionName;

    private String deleteReason;

    private String deploymentId;

    private String description;

    private Long durationInMillis;

    private String endActivityId;

    private Date endTime;

    private String name;

    private String processDefinitionKey;

    private Integer processDefinitionVersion;

    private Map<String, Object> processVariables;

    private String startActivityId;

    private Date startTime;

    private String startUserId;

    private String tenantId;

    private String callbackId;

    private String callbackType;

    private String superProcessInstanceId;

    public HistoricProcessInstanceVo(){}

    public HistoricProcessInstanceVo(HistoricProcessInstance historicProcessInstance){
        id = historicProcessInstance.getId();
        processDefinitionId = historicProcessInstance.getProcessDefinitionId();
        businessKey = historicProcessInstance.getBusinessKey();
        processDefinitionName = historicProcessInstance.getProcessDefinitionName();
        deleteReason = historicProcessInstance.getDeleteReason();
        deploymentId = historicProcessInstance.getDeploymentId();
        description = historicProcessInstance.getDescription();
        durationInMillis = historicProcessInstance.getDurationInMillis();
        endActivityId = historicProcessInstance.getEndActivityId();
        endTime = historicProcessInstance.getEndTime();
        name = historicProcessInstance.getName();
        processDefinitionKey = historicProcessInstance.getProcessDefinitionKey();
        processDefinitionVersion = historicProcessInstance.getProcessDefinitionVersion();
        processVariables = historicProcessInstance.getProcessVariables();
        startActivityId = historicProcessInstance.getStartActivityId();
        startTime = historicProcessInstance.getStartTime();
        startUserId = historicProcessInstance.getStartUserId();
        tenantId = historicProcessInstance.getTenantId();
        callbackId = historicProcessInstance.getCallbackId();
        callbackType = historicProcessInstance.getCallbackType();
        superProcessInstanceId = historicProcessInstance.getSuperProcessInstanceId();
    }
}
