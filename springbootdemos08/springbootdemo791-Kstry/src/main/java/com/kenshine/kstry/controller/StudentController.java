package com.kenshine.kstry.controller;

import cn.kstry.framework.core.engine.StoryEngine;
import cn.kstry.framework.core.engine.facade.ReqBuilder;
import cn.kstry.framework.core.engine.facade.StoryRequest;
import cn.kstry.framework.core.engine.facade.TaskResponse;
import cn.kstry.framework.core.enums.TrackingTypeEnum;
import com.kenshine.kstry.http.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * 调用执行
 * @author kenshine
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StoryEngine storyEngine;

    /**
     * 同步调用执行
     *
     * localhost:8080/student/query
     */
    @GetMapping("/query")
    public R<QueryScoreResponse> studentQuery() {
        QueryScoreRequest request = new QueryScoreRequest();
        request.setStudentId(77L);
        request.setNeedScore(true);
        StoryRequest<QueryScoreResponse> fireRequest = ReqBuilder
                // 指定返回类型
                .returnType(QueryScoreResponse.class)
                // 流程结束的回溯
                .recallStoryHook(WebUtil::recallStoryHook)
                // 指定监控类型
                .trackingType(TrackingTypeEnum.SERVICE_DETAIL)
                // 指定req域参数
                .request(request)
                // 指定var域数据载体，可不指定使用默认值
                .varScopeData(new QueryScoreVarScope())
                // 指定开始事件ID
                .startId("student-score-query-process")
                .build();
        TaskResponse<QueryScoreResponse> result = storyEngine.fire(fireRequest);
        return result.isSuccess() ? R.success(result.getResult()) : R.error(NumberUtils.toInt(result.getResultCode(), -1), result.getResultDesc());
    }

    /**
     * 异步执行调用
     */
    @GetMapping("/scoreQuery")
    public Mono<R<QueryScoreResponse>> scoreQuery() {
        QueryScoreRequest request = new QueryScoreRequest();
        request.setStudentId(66L);
        request.setNeedScore(true);
        StoryRequest<QueryScoreResponse> fireRequest = ReqBuilder
                // 指定返回类型
                .returnType(QueryScoreResponse.class)
                // 流程结束的回溯
                .recallStoryHook(WebUtil::recallStoryHook)
                // 指定监控类型
                .trackingType(TrackingTypeEnum.SERVICE_DETAIL)
                // 指定req域参数
                .request(request)
                // 指定var域数据载体，可不指定使用默认值
                .varScopeData(new QueryScoreVarScope())
                // 指定开始事件ID
                .startId("student-score-query-process")
                .build();
        Mono<QueryScoreResponse> fireAsync = storyEngine.fireAsync(fireRequest);
        return WebUtil.dataDecorate(request, fireAsync);
    }


}