package com.kenshine.health.check;

import io.smallrye.health.api.HealthGroup;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.springframework.stereotype.Component;

/**
 * @author by kenshine
 * @Classname SuccessfulCustom
 * @Description 自定义健康组
 * @Date 2023-12-26 17:24
 * @modified By：
 * @version: 1.0$
 */
@HealthGroup("group1")
@HealthGroup("group2")
@Component
public class SuccessfulCustom implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("successful-check");
    }
}
