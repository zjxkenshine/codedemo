package com.kenshine.health.check;

import io.smallrye.health.api.HealthGroup;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.springframework.stereotype.Component;

/**
 * @author by kenshine
 * @Classname GroupsCheck
 * @Description 健康组测试
 * @Date 2023-12-26 17:26
 * @modified By：
 * @version: 1.0$
 *
 * 可以包括在任何数量的健康组中 包括liveness和readiness
 */
@HealthGroup("custom1")
@HealthGroup("different-group")
@Liveness
@Component
public class GroupsCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("groups-check");
    }
}
