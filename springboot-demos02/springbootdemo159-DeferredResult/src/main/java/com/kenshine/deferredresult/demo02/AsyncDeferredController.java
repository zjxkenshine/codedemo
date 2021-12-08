package com.kenshine.deferredresult.demo02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 9:25
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@Slf4j
public class AsyncDeferredController {
    private final TaskService taskService;

    @Autowired
    public AsyncDeferredController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/deferred", method = RequestMethod.GET, produces = "text/html")
    public DeferredResult<String> executeSlowTask() {
        log.info("接收到请求");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        CompletableFuture.supplyAsync(taskService::execute)
                .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
        //可以处理其他业务
        log.info("Servlet主线程请求释放");
        return deferredResult;
    }

}
