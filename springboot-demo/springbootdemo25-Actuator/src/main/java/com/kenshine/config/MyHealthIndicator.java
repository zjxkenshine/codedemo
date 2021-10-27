package com.kenshine.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 16:44
 * @description：健康指示器
 * @modified By：
 * @version: $
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return null;
    }

    @Override
    public Health health() {
        //自定义的检查方式
        Health.up().build(); //代表健康，服务没问题。

        //服务GG了
        Health.down().withDetail("message", "服务异常").build();
        return null;
    }

}
