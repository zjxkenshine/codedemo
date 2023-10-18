package com.kenshine.ipLimit1.controller;

import com.van.limiter.core.annotation.IpLimit;
import com.van.limiter.core.enums.LimitType;
import com.van.limiter.core.util.IpLimitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动态黑白名单模式
 */
@RestController
public class DynamicIpListController {

    @Autowired
    private IpLimitUtils ipLimitUtils;

    @IpLimit(groupName = "DYNAMIC_TEST", maxTimes = 2, limitType = LimitType.WHITE_LIST)
    @GetMapping("/dynamic/white/get1")
    public String getTest1() {
        return "get1";
    }

    @IpLimit(groupName = "DYNAMIC_TEST", limitType = LimitType.BLACK_LIST)
    @GetMapping("/dynamic/black/get2")
    public String getTest2() {
        return "get2";
    }

    @IpLimit(groupName = "DYNAMIC_TEST", maxTimes = 2)
    @GetMapping("/dynamic/white/get3")
    public String getTest3() {
        return "get3";
    }

    @GetMapping("/dynamic/ip/list/init/white")
    public String dynamicInitWhite() {
        ipLimitUtils.putWhiteIpGroup("DYNAMIC_TEST", "127.0.0.1,0:0:0:0:0:0:0:1");
        return "success";
    }
    @GetMapping("/dynamic/ip/list/init/black")
    public String dynamicInitBlack() {
        ipLimitUtils.putBlackIpGroup("DYNAMIC_TEST", "127.0.0.1,0:0:0:0:0:0:0:1");
        return "success";
    }

    @GetMapping("/dynamic/ip/list/init/black/clear")
    public String dynamicInitBlackRemove() {
        ipLimitUtils.removeBlackIpGroup("DYNAMIC_TEST");
        return "success";
    }

    @GetMapping("/dynamic/ip/list/init/black/delete")
    public String dynamicInitBlackDelete() {
        ipLimitUtils.deleteBlackIpGroupArrayStr("DYNAMIC_TEST", "127.0.0.1,0:0:0:0:0:0:0:1");
        return "success";
    }
}