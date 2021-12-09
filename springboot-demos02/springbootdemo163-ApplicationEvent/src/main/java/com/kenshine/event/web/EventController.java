package com.kenshine.event.web;

import com.kenshine.event.service.CustomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/9 11:19
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class EventController {
    @Resource
    private CustomService customService;

    @GetMapping("/event")
    public String sendEvent(){
        customService.sendMessage("发送消息");
        return "success";
    }

}

