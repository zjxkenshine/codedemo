package com.kenshine.ipLimit1.controller;

import com.van.limiter.core.annotation.IpLimit;
import com.van.limiter.core.enums.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 纯白名单模式测试
 */
@IpLimit(maxTimes = 2, limitType = LimitType.WHITE_LIST, whiteList="${my.white.list}")
@RestController
public class WhiteLimiterTypeController {

    @GetMapping("/white/get1")
    public String getTest1() {
        return "get1";
    }

    @GetMapping("/white/get2")
    public String getTest2() {
        return "get2";
    }

    @GetMapping("/white/get3")
    public String getTest3() {
        return "get3";
    }

}