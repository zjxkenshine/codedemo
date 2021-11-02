package com.kenshine.socketio.config;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.kenshine.socketio.dto.MessageDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 11:09
 * @description：socketIO连接初始化类
 * @modified By：
 * @version: $
 */
@Component
public class SocketIOHandle {

    /**
     * 线程安全map
     */
    public static ConcurrentHashMap<String,SocketIOClient> webSocketMap = new ConcurrentHashMap<>();

    //客户端连上socket服务器时执行此事件
    @OnConnect
    public void onConnect(SocketIOClient client) {
        //用户id
        String userId = client.getHandshakeData().getSingleUrlParam("userId");
        if (userId != null) {
            //所有连接的客户端
            webSocketMap.put(userId, client);
        }
    }

    //客户端断开socket服务器时执行此事件
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        String userId = client.getHandshakeData().getSingleUrlParam("userId");
        if (userId != null) {
            webSocketMap.remove(userId);
            client.disconnect();
        }
    }

    // 服务器向客户端发送事件
    public static <T> void pushMessage(MessageDTO<T> messageDTO) {
        String userId = messageDTO.getUserId();
        if (!StringUtils.isEmpty(userId)) {
            //获取对应客户端
            SocketIOClient client = webSocketMap.get(userId);
            if (client != null) {
                client.sendEvent(messageDTO.getMessage(), messageDTO);
            }
        }
    }

    // 监听消息
    @OnEvent(value = "toServer")
    public void onEvent(SocketIOClient client, AckRequest request, JSONObject data) {
        String toUserId = String.valueOf(data.get("toUserId"));
        String message = String.valueOf(data.get("message"));
        MessageDTO<String> messageDTO = new MessageDTO<>(toUserId, "updateMsg", message);
        pushMessage(messageDTO);
    }




}
