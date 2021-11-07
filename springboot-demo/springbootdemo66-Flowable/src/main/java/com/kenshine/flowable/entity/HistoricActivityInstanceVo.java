package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.engine.history.HistoricActivityInstance;

import java.util.Date;
import java.util.List;

/**
 * HistoricActivityInstanceVo
 * @author: kenshine
 * @create: 2020-01-15 15:09
 **/
@Data
public class HistoricActivityInstanceVo {

    private String id;

    private String deleteReason;

    private Date startTime;

    private Date endTime;

    private Long durationInMillis;

    private String assignee;

    private String executionId;

    private String processDefinitionId;

    private String processInstanceId;

    private String tenantId;

    private Date time;

    private String activityType;

    private String activityId;

    private String taskId;

    private String activityName;

    private String calledProcessInstanceId;

    private List<CommentVo> comment;

    public HistoricActivityInstanceVo(){}

    public HistoricActivityInstanceVo(HistoricActivityInstance historicActivityInstance){
        id = historicActivityInstance.getId();
        deleteReason = historicActivityInstance.getDeleteReason();
        endTime = historicActivityInstance.getEndTime();
        durationInMillis = historicActivityInstance.getDurationInMillis();
        assignee = historicActivityInstance.getAssignee();
        executionId = historicActivityInstance.getExecutionId();
        processDefinitionId = historicActivityInstance.getProcessDefinitionId();
        processInstanceId = historicActivityInstance.getProcessInstanceId();
        tenantId = historicActivityInstance.getTenantId();
        time = historicActivityInstance.getTime();
        activityType = historicActivityInstance.getActivityType();
        activityId = historicActivityInstance.getActivityId();
        startTime = historicActivityInstance.getStartTime();
        taskId = historicActivityInstance.getTaskId();
        activityName = historicActivityInstance.getActivityName();
        calledProcessInstanceId = historicActivityInstance.getCalledProcessInstanceId();
    }
}
