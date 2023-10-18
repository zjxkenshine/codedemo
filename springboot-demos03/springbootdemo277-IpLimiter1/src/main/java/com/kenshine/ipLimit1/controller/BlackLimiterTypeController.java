package com.kenshine.ipLimit1.controller;

import com.van.limiter.core.annotation.IpLimit;
import com.van.limiter.core.enums.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname BlackLimiterTypeController
 * @Description 黑名单模式
 * @Date 2023-10-18 17:43
 * @modified By：
 * @version: 1.0$
 */
@IpLimit(maxTimes = 2, limitType = LimitType.BLACK_LIST, whiteList="${my.blacklist}")
@RestController
public class BlackLimiterTypeController {
    @GetMapping("/black/get1")
    public String getTest1() {
        return "get1";
    }

    @GetMapping("/black/get2")
    public String getTest2() {
        return "get2";
    }

    @GetMapping("/black/get3")
    public String getTest3() {
        return "get3";
    }

}
