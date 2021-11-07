package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.identitylink.api.IdentityLinkInfo;

/**
 * IdentityLinkInfoVo
 * @author: kenshine
 * @create: 2020-01-02 11:34
 **/
@Data
public class IdentityLinkInfoVo {

    private String type;

    private String userId;

    private String groupId;

    private String taskId;

    private String processInstanceId;

    private String scopeId;

    private String scopeType;

    private String scopeDefinitionId;

    public IdentityLinkInfoVo(){}

    public IdentityLinkInfoVo(IdentityLinkInfo identityLinkInfo){
        processInstanceId = identityLinkInfo.getProcessInstanceId();
        groupId = identityLinkInfo.getGroupId();
        scopeDefinitionId = identityLinkInfo.getScopeDefinitionId();
        scopeId = identityLinkInfo.getScopeId();
        scopeType = identityLinkInfo.getScopeType();
        taskId = identityLinkInfo.getTaskId();
        type = identityLinkInfo.getType();
        userId = identityLinkInfo.getUserId();
    }
}
