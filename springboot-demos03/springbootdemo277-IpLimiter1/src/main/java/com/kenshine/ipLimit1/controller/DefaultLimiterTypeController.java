package com.kenshine.ipLimit1.controller;

import com.van.limiter.core.annotation.IpLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 走默认限流策略,不考虑黑白名单参数
 */
@IpLimit(maxTimes = 2)
@RestController
public class DefaultLimiterTypeController {

    @GetMapping("/default/get1")
    public String getTest1() {
        return "get1";
    }

    @GetMapping("/default/get2")
    public String getTest2() {
        return "get2";
    }

    @GetMapping("/default/get3")
    public String getTest3() {
        return "get3";
    }

}