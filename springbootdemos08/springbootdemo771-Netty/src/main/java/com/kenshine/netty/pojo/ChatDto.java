package com.kenshine.netty.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 传输实体类
 * @author kenshine
 */
@Data
@Accessors(chain = true)
public class ChatDto {

    /**
     * 客户端ID 唯一
     */
    private String clientId;

    /**
     * 发送的消息
     */
    private String msg;
}