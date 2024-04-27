package com.kenshine.kstry.http;

import cn.kstry.framework.core.exception.BusinessException;
import cn.kstry.framework.core.monitor.MonitorTracking;
import cn.kstry.framework.core.monitor.NodeTracking;
import cn.kstry.framework.core.monitor.RecallStory;
import cn.kstry.framework.core.util.ExceptionUtil;
import cn.kstry.framework.core.util.GlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kenshine
 * story流程结束的回溯
 */
@Slf4j
public class WebUtil {
    public static void recallStoryHook(RecallStory recallStory) {
        MonitorTracking monitorTracking = recallStory.getMonitorTracking();
        List<NodeTracking> storyTracking = monitorTracking.getStoryTracking();
        List<String> collect = storyTracking.stream().map(nt -> GlobalUtil.format("{}({}ms)", nt.getNodeName(), nt.getSpendTime())).collect(Collectors.toList());
        log.info("Story startId: {}, service node spend list: {}", recallStory.getStartId(), String.join(",", collect));
    }

    /**
     * 结果
     */
    public static <T> Mono<R<T>> resultDecorate(Object req, Mono<R<T>> result) {
        int defErrorCode = -1;
        return result.doOnSuccess(r -> log.info("req: {}, result success: {}", req, r)).onErrorResume(err -> {
            if (err instanceof BusinessException) {
                log.error("req: {}, task-service: {}, result error: ", req, GlobalUtil.transferNotEmpty(err, BusinessException.class).getTaskIdentity(), err);
            } else {
                log.error("req: {}, result error: ", req, err);
            }
            return Mono.just(R.error(ExceptionUtil.tryGetCode(err).map(s -> NumberUtils.toInt(s, defErrorCode)).orElse(defErrorCode), err.getMessage()));
        });
    }

    /**
     * 数据
     */
    public static <T> Mono<R<T>> dataDecorate(Object req, Mono<T> result) {
        return resultDecorate(req, result.flatMap(r -> {
            if (r instanceof R) {
                return (Mono<R<T>>) result;
            }
            return Mono.just(R.success(r));
        }));
    }
}