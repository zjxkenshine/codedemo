package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.engine.impl.persistence.entity.CommentEntityImpl;
import org.flowable.engine.task.Comment;

import java.util.Date;

/**
 * CommentVo
 * @author: kenshine
 * @create: 2020-01-15 16:22
 **/
@Data
public class CommentVo {

    private String id;

    private String processInstanceId;

    private String taskId;

    private Date time;

    private String type;

    private String userId;

    private String message;

    public CommentVo(){}

    public CommentVo(Comment comment){
        id = comment.getId();
        processInstanceId = comment.getProcessInstanceId();
        taskId = comment.getTaskId();
        time = comment.getTime();
        type = comment.getType();
        userId = comment.getUserId();
        message = ((CommentEntityImpl) comment).getMessage();
    }
}
