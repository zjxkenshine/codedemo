package com.kenshine.socketio.web;

import com.kenshine.socketio.config.SocketIOHandle;
import com.kenshine.socketio.dto.MessageDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息推送接口
 */
@RestController
public class IndexController {

    /**
     * 向客户端发送消息
     * @param messageDTO
     */
    @RequestMapping(value = "/updateMsg", method = RequestMethod.POST)
    public void updateMsg(@RequestBody MessageDTO messageDTO) {
        SocketIOHandle.pushMessage(messageDTO);
    }


}
