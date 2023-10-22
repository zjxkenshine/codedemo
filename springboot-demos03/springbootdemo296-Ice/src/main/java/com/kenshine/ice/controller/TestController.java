package com.kenshine.ice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ice.core.Ice;
import com.ice.core.context.IcePack;
import com.ice.core.context.IceRoam;
import com.ice.core.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 示例
 *
 * 活动内容：
 * 重置100元 送5元余额 10.1-10.7
 * 重置50元 送10积分 10.5-10.7
 * 不叠加：100 元只能获得5元，不会获得10积分
 *
 */
@Slf4j
@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestBody Map<String, Object> map) throws JsonProcessingException {
        IcePack pack = JacksonUtils.readJson(JacksonUtils.toJsonString(map), IcePack.class);
        return JacksonUtils.toJsonString(Ice.processCtx(pack));
    }

    /**
     * http://localhost:8080/test01?cost=80&uid=1
     */
    @GetMapping(value = "/test01")
    public String test01(@RequestParam Integer cost, @RequestParam Integer uid) throws JsonProcessingException {
        IcePack pack = new IcePack();
        // 调用recharge规则
        pack.setScene("recharge");
        IceRoam roam = new IceRoam();
        roam.put("cost", cost);
        roam.put("uid", uid);
        // 设置roam
        pack.setRoam(roam);
        return JacksonUtils.toJsonString(Ice.processCtx(pack));
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public String recharge(@RequestParam Integer cost, @RequestParam Integer uid) {
        IcePack pack = new IcePack();
        pack.setScene("recharge");
        IceRoam roam = new IceRoam();
        roam.put("cost", cost);
        roam.put("uid", uid);
        // 设置roam
        pack.setRoam(roam);
        // 触发规则
        Ice.syncProcess(pack);
        return JacksonUtils.toJsonString(roam.get("result"));
    }

    @RequestMapping(value = "/consume", method = RequestMethod.GET)
    public String consume(@RequestParam Integer cost, @RequestParam Integer uid) {
        IcePack pack = new IcePack();
        pack.setScene("consume");
        IceRoam roam = new IceRoam();
        roam.put("cost", cost);
        roam.put("uid", uid);
        pack.setRoam(roam);
        Ice.syncProcess(pack);
        return JacksonUtils.toJsonString(roam.get("result"));
    }
}
