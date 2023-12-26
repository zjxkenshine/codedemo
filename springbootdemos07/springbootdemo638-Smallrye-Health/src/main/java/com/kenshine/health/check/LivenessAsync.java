package com.kenshine.health.check;

import io.smallrye.health.api.AsyncHealthCheck;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author by kenshine
 * @Classname LivenessAsync
 * @Description AsyncHealthCheck 异步健康确认
 * @Date 2023-12-26 17:17
 * @modified By：
 * @version: 1.0$
 */
@Liveness
@Component
public class LivenessAsync implements AsyncHealthCheck {
    @Override
    public Uni<HealthCheckResponse> call() {
        // 活跃度
        return Uni.createFrom().item(HealthCheckResponse.up("liveness-async"))
                .onItem().delayIt().by(Duration.ofMillis(10));
    }
}
