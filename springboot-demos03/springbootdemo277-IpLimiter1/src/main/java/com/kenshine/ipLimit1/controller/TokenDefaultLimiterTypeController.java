package com.kenshine.ipLimit1.controller;

import com.van.limiter.core.annotation.IpLimit;
import com.van.limiter.core.enums.CurrentLimiterType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TokenDefaultLimiterTypeController
 * @Description 默认限流策略,不考虑黑白名单参数
 * @Date 2023-10-18 17:41
 * @modified By：
 * @version: 1.0$
 *
 * 默认 maxTimes - 单位时间内最多请求次数为10
 * 这里改为2
 */
@IpLimit(maxTimes = 2, currentLimiter = CurrentLimiterType.TOKEN_BUCKET)
@RestController
public class TokenDefaultLimiterTypeController {
    @GetMapping("/token/default/get1")
    public String getTest1() {
        return "get1";
    }

    @GetMapping("/token/default/get2")
    public String getTest2() {
        return "get2";
    }

    @GetMapping("/token/default/get3")
    public String getTest3() {
        return "get3";
    }
}
