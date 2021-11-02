package com.kenshine.socketio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 11:10
 * @description：消息实体
 * @modified By：
 * @version: $
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO<T> {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 消息名称
     */
    private String message;

    /**
     * 内容
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
