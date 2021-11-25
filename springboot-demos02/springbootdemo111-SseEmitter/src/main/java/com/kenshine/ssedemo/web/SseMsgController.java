package com.kenshine.ssedemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/25 9:16
 * @description：Sse推送消息
 * @modified By：
 * @version: $
 */
@Controller
public class SseMsgController {

    @RequestMapping("/sse")
    public String see() {
        return "sse";
    }

    /**
     * 这里使用输出的媒体类型为text/event-stream，这是服务端的SSE的支持
     */
    @RequestMapping(value = "/push", produces = "text/event-stream")
    @ResponseBody
    public String push() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(System.currentTimeMillis());
        try {
            //演示每5秒向浏览器推送随机消息
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return "data:Testing 服务端单向推送：=>" + dateStr+ "\n\n";
    }
}
