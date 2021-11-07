package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.identitylink.api.IdentityLink;

/**
 * IdentityLinkVo
 * @author: kenshine
 * @create: 2020-01-02 11:34
 **/
@Data
public class IdentityLinkVo {

    private String type;

    private String userId;

    private String groupId;

    private String taskId;

    private String processInstanceId;

    private String scopeId;

    private String scopeType;

    private String scopeDefinitionId;

    private String processDefinitionId;

    public IdentityLinkVo(){}

    public IdentityLinkVo(IdentityLink identityLink){
        processInstanceId = identityLink.getProcessInstanceId();
        groupId = identityLink.getGroupId();
        scopeDefinitionId = identityLink.getScopeDefinitionId();
        scopeId = identityLink.getScopeId();
        scopeType = identityLink.getScopeType();
        taskId = identityLink.getTaskId();
        type = identityLink.getType();
        userId = identityLink.getUserId();
        processDefinitionId = identityLink.getProcessDefinitionId();

    }
}
