package com.kenshine.websocket.web;

import com.kenshine.websocket.websockets.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 10:17
 * @description：测试接口
 * @modified By：
 * @version: $
 */
@RestController
public class WebSocketController {

    @GetMapping("/page")
    public ModelAndView page() {
        return new ModelAndView("websocket");
    }

    @RequestMapping("/push/{toUID}")
    public ResponseEntity<String> pushToClient(String message, @PathVariable String toUID) throws IOException {
        //发送消息
        WebSocketServer.sendInfo(message, toUID);
        return ResponseEntity.ok("Send Success!");
    }

}
